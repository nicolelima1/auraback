package com.example.aura.Aura_Project2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "rating")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rating;

    @ManyToOne
    @JoinColumn(name = "id_professional", nullable = false)
    private Professional professional;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @Column(nullable = false)
    private BigDecimal score;

    @Column(length = 255)
    private String feedback;

}
