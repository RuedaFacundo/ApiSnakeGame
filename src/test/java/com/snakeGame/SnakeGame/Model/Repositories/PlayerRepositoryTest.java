package com.snakeGame.SnakeGame.Model.Repositories;

import com.snakeGame.SnakeGame.Model.Entities.Player;
import com.snakeGame.SnakeGame.SnakeGameApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@SpringBootTest(classes = {SnakeGameApplication.class})
class PlayerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void findTopScores() {
        Player firstPlayer = new Player();
        firstPlayer.setName("Facu");
        entityManager.persist(firstPlayer);
        entityManager.flush();

        Player secondPlayer = new Player();
        secondPlayer.setName("Pepe");
        entityManager.persist(secondPlayer);
        entityManager.flush();

        List<Player> playerList = playerRepository.findAll();

        assertThat(playerList.size()).isEqualTo(2);
        assertThat(playerList.get(0)).isEqualTo(firstPlayer);
        assertThat(playerList.get(1)).isEqualTo(secondPlayer);

    }
}