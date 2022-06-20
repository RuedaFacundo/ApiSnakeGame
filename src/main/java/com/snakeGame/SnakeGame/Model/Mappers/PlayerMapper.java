package com.snakeGame.SnakeGame.Model.Mappers;

import com.snakeGame.SnakeGame.Model.Domain.PlayerResponseDTO;
import com.snakeGame.SnakeGame.Model.Domain.PlayerDTO;
import com.snakeGame.SnakeGame.Model.Entities.Player;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "playerMapper")
public class PlayerMapper {

    public PlayerResponseDTO entityToDto(Player entity){
        return Optional
                .ofNullable(entity)
                .map(
                        ent -> new PlayerResponseDTO(
                                ent.getId(),
                                ent.getName(),
                                ent.getScore(),
                                ent.getPosition()
                        )
                )
                .orElse(new PlayerResponseDTO());
    }

    public Player dtoToEntity(PlayerDTO dto){
        Player entity = new Player();
        entity.setName(dto.getName());
        entity.setScore(dto.getScore());

        return entity;
    }
}
