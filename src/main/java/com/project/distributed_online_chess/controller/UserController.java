package com.project.distributed_online_chess.controller;

import com.project.distributed_online_chess.dao.UserRepository;
import com.project.distributed_online_chess.dto.UserCreateRequest;
import com.project.distributed_online_chess.dto.UserResponse;
import com.project.distributed_online_chess.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // POST /users
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody UserCreateRequest req) {
        if (req == null
                ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if(repo.existsBySubId(req.subId())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account already exists.");
        }

        User user = new User();
        user.setUsername(req.username());
        user.setSubId(req.subId());
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

    private UserResponse toResponse(User u) {
        return new UserResponse(u.getId(), u.getUsername(), u.getSubId(), u.getProfileImage());
    }
}
