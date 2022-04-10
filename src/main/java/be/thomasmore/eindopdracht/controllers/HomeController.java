package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.model.Game;
import be.thomasmore.eindopdracht.repositories.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private GameRepository gameRepository;

    @GetMapping({"/", "/home", "/{something}"})
    public String home(Model model) {
        Iterable<Game> allGames = gameRepository.findAll();
        List<Game> threeGames = new ArrayList<>();
        int i = 0;
        for (Game game: allGames) {
            if (i < 3) {
                i++;
                threeGames.add(game);
            }
        }
        model.addAttribute("games", threeGames);
        return "home";
    }
}
