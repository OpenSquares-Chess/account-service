package com.project.distributed_online_chess.dto;

public record UserCreateRequest (
        String username,
        String profileImage
) {}
