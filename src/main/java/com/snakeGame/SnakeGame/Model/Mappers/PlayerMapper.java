package com.snakeGame.SnakeGame.Model.Mappers;

import com.snakeGame.SnakeGame.Model.Domain.PlayerDTO;
import com.snakeGame.SnakeGame.Model.Entities.Player;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "playerMapper")
public class PlayerMapper {

    public PlayerDTO entityToDto(Player entity){
        return Optional
                .ofNullable(entity)
                .map(
                        ent -> new PlayerDTO(
                                ent.getId(),
                                ent.getName(),
                                ent.getScore(),
                                ent.getPosition()
                        )
                )
                .orElse(new PlayerDTO());
    }

    public Player dtoToEntity(PlayerDTO dto){
        Player entity = new Player();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setScore(dto.getScore());
        entity.setPosition(dto.getPosition());

        return entity;
    }
}
