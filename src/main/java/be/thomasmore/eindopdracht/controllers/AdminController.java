package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.model.Game;
import be.thomasmore.eindopdracht.repositories.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/gamesedit/{id}")
    public String gamesEdit(Model model, @PathVariable int id) {
        logger.info("gamesedit"+id);
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            model.addAttribute("game", optionalGame.get());
        }
        return "admin/gamesedit";
    }
}
