package com.example.apiRest.repository;

import com.example.apiRest.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmsRepository extends JpaRepository<Films, Long> {
    Films findById(long id);

    List<Films> findByName(String name);

    List<Films> findByNameContaining(String title);
}
