package com.project.account_service.dto;

public record UserResponse (
        String id,
        String username,
        String profileImage,
        String subId
) {}
