package com.example.vedruna.dto;

import java.util.List;

public class PlayerDTO {
    private Long id;
    private String username;
    private List<TrophyDTO> trophies;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TrophyDTO> getTrophies() {
        return trophies;
    }

    public void setTrophies(List<TrophyDTO> trophies) {
        this.trophies = trophies;
    }
}
