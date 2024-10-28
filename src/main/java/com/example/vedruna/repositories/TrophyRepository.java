package com.example.vedruna.repositories;


import com.example.vedruna.persistance.models.Trophy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrophyRepository extends JpaRepository<Trophy, Long> {
}
