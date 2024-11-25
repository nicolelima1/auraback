package com.example.aura.Aura_Project2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "professional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String tel;
    private int rating;
    @Column(name = "horarios_disponiveis")
    private String horarios;
}
