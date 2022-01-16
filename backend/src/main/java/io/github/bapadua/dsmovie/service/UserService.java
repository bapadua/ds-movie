package io.github.bapadua.dsmovie.service;

import io.github.bapadua.dsmovie.domain.entity.User;
import io.github.bapadua.dsmovie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(final User user) {
        return repository.saveAndFlush(user);
    }

    public User findByEmail(final String email) {
        return repository.findByEmail(email);
    }
}
