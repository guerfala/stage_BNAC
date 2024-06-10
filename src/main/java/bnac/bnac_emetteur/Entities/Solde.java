package bnac.bnac_emetteur.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="Solde")
public class Solde {
    @Id
    @Column(nullable = false)
    private int Matricule;

@Column(nullable=false)
    private int Solde;

    @Column(nullable=false)
    private float SoldeNantissement;

    @Column(nullable = false)
    private LocalDateTime dateMaj;

    @Column(nullable=false)
    private float SoldeOpposition;

    @Column(length =16,nullable=false)
    private String CodeBO;
}
