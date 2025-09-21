package com.project.distributed_online_chess.controller;

import com.project.distributed_online_chess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public endpoint.";
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "You are authenticated.";
    }


}
