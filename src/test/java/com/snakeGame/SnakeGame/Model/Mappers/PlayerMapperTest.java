package com.snakeGame.SnakeGame.Model.Mappers;

import com.snakeGame.SnakeGame.Model.Domain.PlayerDTO;
import com.snakeGame.SnakeGame.Model.Domain.PlayerResponseDTO;
import com.snakeGame.SnakeGame.Model.Entities.Player;
import com.snakeGame.SnakeGame.SnakeGameApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SnakeGameApplication.class})
class PlayerMapperTest {

    PlayerMapper playerMapper = new PlayerMapper();
    Player player = new Player();
    PlayerDTO playerDTO = new PlayerDTO();
    PlayerResponseDTO playerResponseDTO = new PlayerResponseDTO();

    @BeforeEach
    void init() {
        player.setId(1);
        player.setName("Pepe");
        player.setPosition(2);
        player.setScore(20);

        playerResponseDTO.setId(1);
        playerResponseDTO.setPosition(2);
        playerResponseDTO.setName("Pepe");
        playerResponseDTO.setScore(20);

        playerDTO.setName("Pepe");
        playerDTO.setScore(20);
    }

    @Test
    void entityToDto() {
        assertEquals(playerResponseDTO, playerMapper.entityToDto(player));
    }

    @Test
    void dtoToEntity() {
        Player entity =  playerMapper.dtoToEntity(playerDTO);
        assertEquals(player.getName(), entity.getName());
    }
}