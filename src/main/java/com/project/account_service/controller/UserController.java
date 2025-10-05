package com.project.account_service.controller;

import com.project.account_service.dao.UserRepository;
import com.project.account_service.dto.UserCreateRequest;
import com.project.account_service.dto.UserResponse;
import com.project.account_service.entities.User;
import com.project.account_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;
    private final UserService userService;

    public UserController(UserRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    // POST /users
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserCreateRequest req) {
        if (req == null
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        String sub = userService.getCurrentUserId();

        if(repo.existsBySubId(sub)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account already exists.");
        }

        User user = new User();
        user.setUsername(req.username());
        user.setSubId(sub);
        user.setProfileImage(req.profileImage());

        repo.save(user);
        return toResponse(user);
    }

    // GET /users/{id}
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable String id) {
        User u = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return toResponse(u);
    }

    // GET /users/self
    @GetMapping("/self")
    public UserResponse getSelf(@AuthenticationPrincipal Jwt principal) {
        String sub = principal.getSubject();
        User u = repo.findBySubId(sub).orElseThrow(()  -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return toResponse(u);
    }

    private UserResponse toResponse(User u) {
        return new UserResponse(u.getId(), u.getUsername(), u.getProfileImage(), u.getSubId());
    }
}
