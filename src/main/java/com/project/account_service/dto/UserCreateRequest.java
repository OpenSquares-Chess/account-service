package com.project.account_service.dto;

public record UserCreateRequest (
        String username,
        String profileImage
) {}
