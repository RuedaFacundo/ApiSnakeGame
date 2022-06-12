package com.snakeGame.SnakeGame.Model.Repositories;

import com.snakeGame.SnakeGame.Model.Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "playerRepository")
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
