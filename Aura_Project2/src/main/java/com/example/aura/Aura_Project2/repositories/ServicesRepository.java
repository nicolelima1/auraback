package com.example.aura.Aura_Project2.repositories;

import com.example.aura.Aura_Project2.domain.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServicesRepository extends JpaRepository <Services, Long> {

}
