package com.project.account_service.dto;

public record GameResponse (
        String gameId,
        String playerOneId,
        String playerTwoId,
        int playerOneRating,
        int playerTwoRating,
        String date,
        String pgn
)
{}
