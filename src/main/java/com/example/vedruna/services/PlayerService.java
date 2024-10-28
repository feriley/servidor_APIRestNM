package com.example.vedruna.services;

import com.example.vedruna.dto.PlayerDTO;
import com.example.vedruna.dto.TrophyDTO;
import com.example.vedruna.persistance.models.Player;
import com.example.vedruna.persistance.models.Trophy;
import com.example.vedruna.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public Optional<PlayerDTO> getPlayerById(Long id) {
        return playerRepository.findById(id).map(this::convertToDTO);
    }

    public Player createPlayer(Player player) {
        player.setTrophies(List.of());
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
    public PlayerDTO addTrophyToPlayer(Long playerId, Trophy trophy) {
        Player player = playerRepository.findById(playerId)
            .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));
    
        player.getTrophies().add(trophy); // Associate the trophy with the player
        playerRepository.save(player); // Save the updated player
    
        return convertToDTO(player); // Return the PlayerDTO
    }

    // Métodos de conversión
    public PlayerDTO convertToDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getIdplayer());
        dto.setUsername(player.getUsername());
        dto.setTrophies(player.getTrophies().stream().map(this::convertToDTO).collect(Collectors.toList()));
        return dto;
    }

    public TrophyDTO convertToDTO(Trophy trophy) {
        TrophyDTO dto = new TrophyDTO();
        dto.setId(trophy.getIdtrophie());
        dto.setTitle(trophy.getTitle());
        dto.setDescription(trophy.getDescription());
        return dto;
    }
}
