package com.example.apiRest.repository;

import com.example.apiRest.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmsRepository extends JpaRepository<Films, Long> {
    Films findById(long id);
}
