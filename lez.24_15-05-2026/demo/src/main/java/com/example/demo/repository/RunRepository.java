package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Location;
import com.example.demo.model.Run;

@Repository
public interface RunRepository extends JpaRepository<Run, Integer> {

    List<Run> findByTitle(String title);

    List<Run> findByMilesGreaterThan(Integer miles);

    List<Run> findByLocation(Location location);

    List<Run> findByLocationAndMilesGreaterThan(Location location, double miles);

    Optional<Run> findFirstByTitle(String title);

    boolean existsByTitle(String title);

    // JPQL: usa "Run" (nome classe) e "r.location" (nome campo Java)
    @Query("SELECT r FROM Run r WHERE r.location = :location ORDER BY r.miles DESC")
    List<Run> findByLocationOrderedByMiles(@Param("location") Location location);
}
