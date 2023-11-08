package com.example.cinema.repository;

import com.example.cinema.domain.data.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HallRepository extends JpaRepository<Hall, Long> {
}
