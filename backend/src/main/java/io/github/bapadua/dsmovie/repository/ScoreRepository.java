package io.github.bapadua.dsmovie.repository;

import io.github.bapadua.dsmovie.domain.entity.Score;
import io.github.bapadua.dsmovie.domain.entity.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}
