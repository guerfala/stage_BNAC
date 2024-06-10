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
    @Column(name = "Matricule", nullable = false)
    private int Matricule;

@Column(name="Solde", nullable=false)
    private int Solde;

    @Column(name="SoldeNantissement", nullable=false)
    private float SoldeNantissement;

    @Column(name = "DateMaj",nullable = false)
    private LocalDateTime dateMaj;

    @Column(name="SoldeOpposition", nullable=false)
    private float SoldeOpposition;

    @Column(name="CodeBO",length =16,nullable=false)
    private String CodeBO;
}
