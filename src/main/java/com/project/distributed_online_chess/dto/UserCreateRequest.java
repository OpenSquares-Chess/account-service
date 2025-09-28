package com.project.distributed_online_chess.dto;


import java.util.Set;


public record UserCreateRequest (
        String username,
        String profileImage
) {}
