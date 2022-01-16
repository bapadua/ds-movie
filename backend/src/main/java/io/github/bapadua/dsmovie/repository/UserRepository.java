package io.github.bapadua.dsmovie.repository;

import io.github.bapadua.dsmovie.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    User findByEmail(String email);
}
