package com.kloudone.services;

import java.util.Optional;

import com.kloudone.model.User;

public interface UserService {
	
	Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);

}
