package com.example.cinema.repository;

import com.example.cinema.domain.data.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
