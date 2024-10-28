package com.example.vedruna.controllers;

import com.example.vedruna.dto.PlayerDTO;
import com.example.vedruna.persistance.models.Player;
import com.example.vedruna.persistance.models.Trophy;
import com.example.vedruna.services.PlayerService;
import com.example.vedruna.services.TrophyService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Añado CORS a los controladores 
public class PlayerController {

    private final PlayerService playerService;
    private final TrophyService trophyService;

    public PlayerController(PlayerService playerService, TrophyService trophyService) {
        this.playerService = playerService;
        this.trophyService = trophyService;
    }

    // Obtener todos los jugadores
    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // Obtener un jugador por ID
    @GetMapping("/{id}")
    public PlayerDTO getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id)
            .orElseThrow(() -> new RuntimeException("Player not found with id: " + id));
    }

    @PostMapping
    public PlayerDTO createPlayer(@RequestBody Player player) {
        return playerService.convertToDTO(playerService.createPlayer(player));
    }

    @PostMapping("/{playerId}/trophies/{trophyId}")
    public PlayerDTO addTrophyToPlayer(@PathVariable Long playerId, @PathVariable Long trophyId) {
        Trophy trophy = trophyService.getTrophyById(trophyId)
            .orElseThrow(() -> new RuntimeException("Trophy not found with id: " + trophyId));
        return playerService.addTrophyToPlayer(playerId, trophy);
    }
    
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
