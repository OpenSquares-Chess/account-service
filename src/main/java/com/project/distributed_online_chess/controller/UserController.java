package com.project.distributed_online_chess.controller;


import com.project.distributed_online_chess.dao.UserRepository;
import com.project.distributed_online_chess.dto.UserCreateRequest;
import com.project.distributed_online_chess.dto.UserResponse;
import com.project.distributed_online_chess.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;


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
    public UserResponse create(UserCreateRequest req ){
        if(req == null || req.username() == null || req.password() == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username and password are required");
        }


        User user = new User();
        user.setUsername(req.username());


        repo.save(user);
        return toResponse(user);
    }
    // GET /users/uuid
    @GetMapping("/{uuid}")
    public UserResponse getById(@PathVariable String id) {
        User u = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return toResponse(u);
    }


    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    private UserResponse toResponse(User u) {
        return new UserResponse(u.getUuid(), u.getUsername());
    }
}
