package com.snakeGame.SnakeGame.Services;

import com.snakeGame.SnakeGame.Exception.PlayerNotFound;
import com.snakeGame.SnakeGame.Model.Domain.PlayerDTO;
import com.snakeGame.SnakeGame.Model.Mappers.PlayerMapper;
import com.snakeGame.SnakeGame.Model.Repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "playerService")
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public List<PlayerDTO> findAll() {
        return playerRepository.findAll().stream()
                .map(playerMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public PlayerDTO savePlayer(PlayerDTO dto) {
        return playerMapper.entityToDto(
                playerRepository.save(
                        playerMapper.dtoToEntity(dto)));
    }

    public PlayerDTO getById(int id) {
        if (playerRepository.existsById(id)) {
            return playerMapper.entityToDto(
                    playerRepository.getById(Integer.valueOf(id)));
        } else {
            throw new PlayerNotFound("No se encontro el jugador con ese ID");
        }
    }
}
