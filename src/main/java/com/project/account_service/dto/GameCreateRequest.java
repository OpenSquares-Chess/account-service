package com.project.account_service.dto;

public record GameCreateRequest (
        String playerOneId,
        String playerTwoId,
        int playerOneRating,
        int playerTwoRating,
        String date,
        String pgn
)
{}
