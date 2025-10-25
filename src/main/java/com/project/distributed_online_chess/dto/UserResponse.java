package com.project.distributed_online_chess.dto;

public record UserResponse (
        String id,
        String username,
        String profileImage,
        String subId
) {}
