package io.github.bapadua.dsmovie.service;


import io.github.bapadua.dsmovie.domain.dto.MovieDTO;
import io.github.bapadua.dsmovie.domain.dto.ScoreDTO;
import io.github.bapadua.dsmovie.domain.entity.Movie;
import io.github.bapadua.dsmovie.domain.entity.Score;
import io.github.bapadua.dsmovie.domain.entity.User;
import io.github.bapadua.dsmovie.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    MovieService movieService;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = new User(null, dto.getEmail());
        user = userService.save(user);

        MovieDTO result = movieService.findById(dto.getMovieId());
        Movie movie = result.toEntity();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        repository.saveAndFlush(score);

        Double totalScore = movie.getScoreValue();
        Integer counter = movie.getScoreCount();
        Double avg = totalScore / counter;
        movie.setScore(avg);
        movie.setCount(counter);

        return movieService.save(movie);
    }


}
