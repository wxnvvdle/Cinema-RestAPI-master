package com.example.cinema.repository;

import com.example.cinema.domain.data.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {
}
