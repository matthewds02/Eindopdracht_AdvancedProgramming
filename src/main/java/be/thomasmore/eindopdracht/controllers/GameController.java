package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.model.Game;
import be.thomasmore.eindopdracht.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping({"/gameslist"})
    public String about(Model model) {
        Iterable<Game> allGames = gameRepository.findAll();
        model.addAttribute("games", allGames);
        model.addAttribute("nrGames", gameRepository.count());
        return "gameslist";
    }
}
