package com.example.aura.Aura_Project2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "scheduling")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_scheduling;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_professional", nullable = false)
    private Professional professional;

    @Column(name = "date_scheduling", nullable = false)
    private LocalDate dateScheduling;

    @Column(name = "time_scheduling", nullable = false)
    private LocalTime timeScheduling;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private SchedulingStatus status;

    public enum SchedulingStatus {
        AGENDADO,
        CONCLUIDO,
        CANCELADO
    }
}
