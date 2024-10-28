package com.example.vedruna.persistance.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idplayer;

    private String username;

    @ManyToMany
    @JoinTable(
        name = "players_has_trophies",
        joinColumns = @JoinColumn(name = "players_idplayer"), // Clave foránea que apunta a "players"
        inverseJoinColumns = @JoinColumn(name = "trophies_idtrophie") // Clave foránea que apunta a "trophies"
    )
    private List<Trophy> trophies;
}
