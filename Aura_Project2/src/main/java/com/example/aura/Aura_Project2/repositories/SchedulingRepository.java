package com.example.aura.Aura_Project2.repositories;

import com.example.aura.Aura_Project2.domain.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository <Scheduling, Long> {
}
