package com.snakeGame.SnakeGame.Model.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResponseDTO {
    Integer id;
    String name;
    Integer score;
    Integer position;

}
