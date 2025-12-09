package com.project.account_service.service;

import com.project.account_service.dao.GameRepository;
import com.project.account_service.dto.GameCreateRequest;
import com.project.account_service.dto.GameResponse;
import com.project.account_service.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Page<Game> getGameHistory(String userId, int page, int size) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, ("date")));
        return gameRepository.findByUserId(userId, pageable);
    }
}
