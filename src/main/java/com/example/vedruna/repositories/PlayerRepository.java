package com.example.vedruna.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vedruna.persistance.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
