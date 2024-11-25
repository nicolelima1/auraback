package com.example.aura.Aura_Project2.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "services")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String specialization;
    @ManyToOne
    @JoinColumn(name = "id_professional", nullable = false)
    private Professional professional;

}
