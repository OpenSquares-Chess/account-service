package com.project.distributed_online_chess.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
