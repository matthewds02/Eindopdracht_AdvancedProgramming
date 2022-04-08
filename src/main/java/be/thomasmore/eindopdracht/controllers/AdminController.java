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



    /* Version1 takes a long time but is easy to understand (parameters are different)
    why DateTimeFormat = https://stackoverflow.com/questions/46414394/map-html-input-date-to-localdate-of-java-object
    https://myshittycode.com/2017/06/22/spring-mvc-failed-to-convert-value-of-type-java-lang-string-to-required-type-java-time-localdatetime/
    //
    @PostMapping("/gamesedit/{id}")
    public String gamesEditPost(Model model, @PathVariable int id, @RequestParam String gameName,
                                @RequestParam String extraInfo, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate gameReleaseDate,
                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate crackedDate, @RequestParam String publisher,
                                @RequestParam String crackedBy, @RequestParam boolean cracked, @RequestParam boolean playstation4,
                                @RequestParam boolean playstation5, @RequestParam boolean xbox, @RequestParam boolean pc) {
        logger.info("gameseditpost : "+id + " -- new name: " + gameName + " -- new info: " + extraInfo +
                " -- new release date: " + gameReleaseDate + " -- new cracked date: " + crackedDate +
                " -- new publisher: " + publisher + " -- new cracked by: " + crackedBy + " -- is it cracked?: " + cracked +
                " -- on playstation4?: " + playstation4 + " -- on playstation5?: " + playstation5 + " -- on xbox?: " + xbox +
                " -- on pc?: " + pc);
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.setGameName(gameName);
            game.setExtraInfo(extraInfo);
            game.setGameReleaseDate(gameReleaseDate);
            game.setCrackedDate(crackedDate);
            game.setPublisher(publisher);
            game.setCrackedBy(crackedBy);
            game.setCracked(cracked);
            game.setPlaystation4(playstation4);
            game.setPlaystation5(playstation5);
            game.setXbox(xbox);
            game.setPc(pc);
            gameRepository.save(game);
            model.addAttribute("game", game);
        }
        return "redirect:/gamesdetails/"+id;
    }*/

    /* Version2 much shorter and faster
    @PostMapping("/gamesedit/{id}")
    public String gamesEditPost(Model model, @PathVariable int id, @ModelAttribute("game") Game game) {
        logger.info("gameseditpost : " + id + " -- new name: " + game.getGameName());
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game gameToUpdate = optionalGame.get();
            gameToUpdate.setGameName(game.getGameName());
            gameToUpdate.setExtraInfo(game.getExtraInfo());
            gameToUpdate.setGameReleaseDate(game.getGameReleaseDate());
            gameToUpdate.setCrackedDate(game.getCrackedDate());
            gameToUpdate.setPublisher(game.getPublisher());
            gameToUpdate.setCrackedBy(game.getCrackedBy());
            gameToUpdate.setCracked(game.isCracked());
            gameToUpdate.setPlaystation4(game.isPlaystation4());
            gameToUpdate.setPlaystation5(game.isPlaystation5());
            gameToUpdate.setXbox(game.isXbox());
            gameToUpdate.setPc(game.isPc());
            gameRepository.save(gameToUpdate);
        }
        return "redirect:/gamesdetails/"+id;
    } */

    /* Version 3 the fastest and easier to look at*/
    @PostMapping("/gamesedit/{id}")
    public String gamesEditPost(Model model, @PathVariable int id, @ModelAttribute("game") Game game) {
        logger.info("gamesEditPost " + id + " -- new name=" + game.getGameName());
        gameRepository.save(game);

        return "redirect:/gamesdetails/"+id;
    }

    @ModelAttribute("game")
    public Game findGame(Model model, @PathVariable(required = false) Integer id) {
        logger.info("findGame "+id);
        if (id!=null) {
            Optional<Game> optionalGame = gameRepository.findById(id);
            if (optionalGame.isPresent()) return optionalGame.get();
        }

        return new Game();
    }

    @GetMapping("/gamesnew")
    public String gamesNew(Model model) {
        logger.info("gamesnew");

        return "admin/gamesnew";
    }

    @PostMapping("/gamesnew")
    public String gamesNewPost(Model model, @ModelAttribute("game") Game game) {
        logger.info("gamesNewPost -- new name=" + game.getGameName() + " -- new info: " + game.getExtraInfo());
        gameRepository.save(game);

        return "redirect:/gamesdetails/"+game.getId();
    }
}
