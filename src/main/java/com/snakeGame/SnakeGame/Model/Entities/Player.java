package com.snakeGame.SnakeGame.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name ="player")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED")
    public Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    public String name;

    @Column(name = "score", columnDefinition = "INTEGER")
    public Integer score;

    @Transient
    @Column(name = "position", columnDefinition = "INTEGER")
    public Integer position;
}
