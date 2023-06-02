package com.example.DTO.repository;

import com.example.DTO.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByUser(Long id);
    Pokemon findByName(String name);

}
