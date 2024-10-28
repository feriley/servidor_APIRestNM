package com.example.vedruna.controllers;

import com.example.vedruna.dto.TrophyDTO;
import com.example.vedruna.persistance.models.Trophy;
import com.example.vedruna.services.TrophyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trophies")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Añado CORS a los controladores 
public class TrophyController {

    private final TrophyService trophyService;

    public TrophyController(TrophyService trophyService) {
        this.trophyService = trophyService;
    }

    @GetMapping
    public List<TrophyDTO> getAllTrophies() {
        return trophyService.getAllTrophies();
    }

    @PostMapping
    public TrophyDTO createTrophy(@RequestBody Trophy trophy) {
        Trophy newTrophy = trophyService.createTrophy(trophy);
        return trophyService.convertToDTO(newTrophy);
    }
}
