package com.project.account_service.controller;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
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
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Value("${keycloak.realm}")
    private String realm;

    private final UserRepository repo;
    private final UserService userService;
    private final Keycloak keycloakAdminClient;

    public UserController(UserRepository repo, UserService userService, Keycloak keycloakAdminClient) {
        this.repo = repo;
        this.userService = userService;
        this.keycloakAdminClient = keycloakAdminClient;
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

        try {
            UserResource userResource = keycloakAdminClient.realm(realm).users().get(user.getSubId());
            UserRepresentation userRep = userResource.toRepresentation();
            Map<String, List<String>> attributes = userRep.getAttributes() != null ? userRep.getAttributes() : new HashMap<>();
            attributes.put("accountId", List.of(user.getId()));
            userRep.setAttributes(attributes);
            userResource.update(userRep);
        } catch (Exception e) {
            repo.delete(user);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
