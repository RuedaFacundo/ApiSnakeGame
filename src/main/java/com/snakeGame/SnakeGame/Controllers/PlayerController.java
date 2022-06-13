package com.snakeGame.SnakeGame.Controllers;

import com.snakeGame.SnakeGame.Model.Domain.PlayerDTO;
import com.snakeGame.SnakeGame.Services.PlayerService;
import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> findAll() {
        return ResponseEntity.ok(
                playerService.findAll()
        );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlayerDTO> getById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(
                playerService.getById(id)
        );
    }

    @GetMapping(value = "/top")
    public ResponseEntity<List<PlayerDTO>> findTopScores() {
        return ResponseEntity.ok(
                playerService.getTopPlayers()
        );
    }

    @PostMapping
    public Map<String, String> save(@RequestBody @NotNull PlayerDTO dto){
        PlayerDTO playerDTO = playerService.savePlayer(dto);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", playerDTO.getId().toString());
        map.put("mensaje: ", "Añadido correctamente");
        return map;
    }
}
