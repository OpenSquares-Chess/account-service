package com.project.distributed_online_chess.controller;

import com.project.distributed_online_chess.dao.GameInformationRepository;
import com.project.distributed_online_chess.dto.GameResponse;
import com.project.distributed_online_chess.dto.UserResponse;
import com.project.distributed_online_chess.entities.GameInformation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameInfoController {

    private final GameInformationRepository gameRepo;

    public GameInfoController(GameInformationRepository gameRepo) {
        this.gameRepo = gameRepo;
    }

    @PostMapping
    public GameResponse SaveGameInfo(@RequestBody GameInformation gameInfo) {

        gameRepo.save(gameInfo);
        return toResponse(gameInfo);
    }


}
