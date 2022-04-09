package be.thomasmore.eindopdracht.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/", "/home", "/{something}"})
    public String home(Model model) {
        return "home";
    }
}
