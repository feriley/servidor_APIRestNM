package com.example.vedruna.services;

import com.example.vedruna.dto.TrophyDTO;
import com.example.vedruna.persistance.models.Trophy;
import com.example.vedruna.repositories.TrophyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrophyService {
    private final TrophyRepository trophyRepository;

    public TrophyService(TrophyRepository trophyRepository) {
        this.trophyRepository = trophyRepository;
    }
      // Método que debería existir para obtener un trofeo por su ID
      public Optional<Trophy> getTrophyById(Long id) {
        return trophyRepository.findById(id);
    }

    public List<TrophyDTO> getAllTrophies() {
        return trophyRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public Trophy createTrophy(Trophy trophy) {
        return trophyRepository.save(trophy);
    }

    // Método de conversión
    public TrophyDTO convertToDTO(Trophy trophy) {
        TrophyDTO dto = new TrophyDTO();
        dto.setId(trophy.getIdtrophie());
        dto.setTitle(trophy.getTitle());
        dto.setDescription(trophy.getDescription());
        return dto;
    }
}
