package com.example.aura.Aura_Project2.repositories;

import com.example.aura.Aura_Project2.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository <Rating, Long > {
}
