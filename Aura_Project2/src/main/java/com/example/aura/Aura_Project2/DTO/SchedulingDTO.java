package com.example.aura.Aura_Project2.DTO;

import com.example.aura.Aura_Project2.domain.Scheduling;

import java.time.LocalDate;
import java.time.LocalTime;

public record SchedulingDTO(LocalDate dateScheduling, LocalTime timeScheduling,String SchedulingStatus) {
}
