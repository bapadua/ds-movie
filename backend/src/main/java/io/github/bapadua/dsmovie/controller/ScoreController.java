package io.github.bapadua.dsmovie.controller;

import io.github.bapadua.dsmovie.domain.dto.MovieDTO;
import io.github.bapadua.dsmovie.domain.dto.ScoreDTO;
import io.github.bapadua.dsmovie.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public ResponseEntity<MovieDTO> saveScore(@RequestBody ScoreDTO dto) {
        return ResponseEntity.ok(service.saveScore(dto));
    }

}
