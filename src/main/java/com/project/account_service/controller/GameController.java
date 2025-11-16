package com.project.account_service.controller;

import com.project.account_service.dto.GameCreateRequest;
import com.project.account_service.dto.GameResponse;
import com.project.account_service.entities.Game;
import com.project.account_service.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<GameResponse> createGame(@RequestBody GameCreateRequest request) {
        GameResponse createGame = gameService.createGame(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createGame);
    }

    @GetMapping("/history/{userId}")
    public Page<Game> getUserGames(@PathVariable String userId,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "20") int size
                                   ) {
        return gameService.getGameHistory(userId, page, size);
    }
}
