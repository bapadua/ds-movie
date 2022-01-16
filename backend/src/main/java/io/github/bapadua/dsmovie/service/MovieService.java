package io.github.bapadua.dsmovie.service;

import io.github.bapadua.dsmovie.domain.dto.MovieDTO;
import io.github.bapadua.dsmovie.domain.entity.Movie;
import io.github.bapadua.dsmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MovieService")
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional
    public MovieDTO save(final Movie movie) {
        Movie save = repository.saveAndFlush(movie);
        return new MovieDTO(save);
    }

    @Transactional
    public MovieDTO save(final MovieDTO movie) {
        Movie save = repository.saveAndFlush(movie.toEntity());
        return new MovieDTO(save);
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> movieList = repository.findAll(pageable);
        return movieList.map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        return new MovieDTO(movie);
    }
}
