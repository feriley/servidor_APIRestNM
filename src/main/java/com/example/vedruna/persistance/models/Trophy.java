package com.example.vedruna.persistance.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Trophy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtrophie;

    private String title;
    private String description;

    @ManyToMany(mappedBy = "trophies")
    private List<Player> players;
}
