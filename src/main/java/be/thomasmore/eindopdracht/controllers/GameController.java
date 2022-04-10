package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.model.Game;
import be.thomasmore.eindopdracht.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping({"/gameslist", "/gameslist/{something}"})
    public String about(Model model) {
        Iterable<Game> allGames = gameRepository.findAll();
        model.addAttribute("games", allGames);
        return "gameslist";
    }

    @GetMapping({"/gamesdetails/{id}", "/gamesdetails"})
    public String gamesdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "gamesdetails";
        Optional<Game> optionalGame = gameRepository.findById(id);
        Optional<Game> optionalPrev = gameRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Game> optionalNext = gameRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalGame.isPresent()) {
            Game g = optionalGame.get();
            model.addAttribute("game", g);
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", gameRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", gameRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "gamesdetails";
    }
}
