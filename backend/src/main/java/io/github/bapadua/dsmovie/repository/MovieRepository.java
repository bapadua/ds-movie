package io.github.bapadua.dsmovie.repository;

import io.github.bapadua.dsmovie.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
