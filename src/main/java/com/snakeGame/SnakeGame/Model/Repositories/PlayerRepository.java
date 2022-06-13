package com.snakeGame.SnakeGame.Model.Repositories;

import com.snakeGame.SnakeGame.Model.Entities.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "playerRepository")
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query("FROM player p ORDER BY p.score DESC")
    List<Player> findTopScores(Pageable pageable);

}
