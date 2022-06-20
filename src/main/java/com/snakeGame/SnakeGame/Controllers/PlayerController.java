package com.snakeGame.SnakeGame.Controllers;

import com.snakeGame.SnakeGame.Model.Domain.PlayerDTO;
import com.snakeGame.SnakeGame.Model.Domain.PlayerResponseDTO;
import com.snakeGame.SnakeGame.Services.PlayerService;
import com.sun.istack.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
@Api(tags = "player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    @ApiOperation(value = "Get All players")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied")})
    public ResponseEntity<List<PlayerResponseDTO>> findAll() {
        return ResponseEntity.ok(
                playerService.findAll()
        );
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get Player by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied")})
    public ResponseEntity<PlayerResponseDTO> getById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(
                playerService.getById(id)
        );
    }

    @GetMapping(value = "/top")
    @ApiOperation(value = "Get top players")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied")})
    public ResponseEntity<List<PlayerResponseDTO>> findTopScores() {
        return ResponseEntity.ok(
                playerService.getTopPlayers()
        );
    }

    @PostMapping
    @ApiOperation(value = "Save Player")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Player saved successfully",
                    response = String.class),
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied")})
    public Map<String, String> save(@RequestBody @NotNull PlayerDTO dto){
        PlayerResponseDTO playerResponseDTO = playerService.savePlayer(dto);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", playerResponseDTO.getId().toString());
        map.put("message: ", "Saved successfully");
        return map;
    }
}
