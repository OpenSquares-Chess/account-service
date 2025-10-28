package com.project.account_service.controller;

import com.project.account_service.entities.Game;
import com.project.account_service.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/history/{userId}")
    public Page<Game> getUserGames(@PathVariable String userId,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "20") int size
                                   ) {
        return gameService.getGameHistory(userId, page, size);
    }
}
