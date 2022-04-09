package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.model.User;
import be.thomasmore.eindopdracht.repositories.GameRepository;
import be.thomasmore.eindopdracht.repositories.ImageRepository;
import be.thomasmore.eindopdracht.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/gameslist";
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(Principal principal, Model model) {
        if (principal == null) return "redirect:/gameslist";
        return "user/logout";
    }

    @GetMapping("/register")
    public String register(Principal principal) {
        if (principal != null) return "redirect:/gameslist";
        return "user/register";
    }

    @PostMapping("/register")
    public String registerPost(Principal principal,
                               @RequestParam String userName,
                               @RequestParam String password) {
        if (principal != null) return "redirect:/partylist";
        if (userName==null || userName.trim().equals("")) return "redirect:/gameslist";
        if (password==null || password.trim().equals("")) return "redirect:/gameslist";
        //userName = userName.trim();
        Optional<User> optionalUser = userRepository.findByUsername(userName);
        if (optionalUser.isPresent()) return "redirect:/gameslist";
        String encodedPassword = encoder.encode(password.trim());
        User user = new User(userName, encodedPassword, "ROLE_USER");
        userRepository.save(user);
        autologin(userName, password.trim());
        return "redirect:/gameslist";
    }

    private void autologin(String userName, String password) {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(userName, password);
        try {
            Authentication auth = authenticationManager.authenticate(token);
            logger.info("authentication: " + auth.isAuthenticated());
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}

