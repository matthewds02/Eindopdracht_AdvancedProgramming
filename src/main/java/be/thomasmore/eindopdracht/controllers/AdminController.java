package be.thomasmore.eindopdracht.controllers;

import be.thomasmore.eindopdracht.model.Game;
import be.thomasmore.eindopdracht.repositories.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
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

    @PostMapping("/gamesedit/{id}")
    public String partyEditPost(Model model, @PathVariable int id, @RequestParam String gameName,
                                @RequestParam String extraInfo, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate gameReleaseDate,
                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate crackedDate, @RequestParam String publisher,
                                @RequestParam String crackedBy) {
        logger.info("gameseditpost : "+id + " -- new name: " + gameName + " -- new info: " + extraInfo +
                " -- new release date: " + gameReleaseDate + " -- new cracked date: " + crackedDate +
                " -- new publisher: " + publisher + " -- new cracked by: " + crackedBy);
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.setGameName(gameName);
            game.setExtraInfo(extraInfo);
            game.setGameReleaseDate(gameReleaseDate);
            game.setCrackedDate(crackedDate);
            game.setPublisher(publisher);
            game.setCrackedBy(crackedBy);
            gameRepository.save(game);
            model.addAttribute("game", game);
        }
        return "admin/gamesedit";
    }
}
