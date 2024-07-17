package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actionnaire_N {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Matricule;

    @JoinColumn(name = "IdEmetteur", nullable = false)
    @ManyToOne
    private Emetteur emetteur;

    @Column(nullable = false, length = 128)
    private String Libelle_Client;

    @Column(nullable = true, length = 32)
    private String NaturePiece;

    @Column(nullable = true, length = 16)
    private String Identifiant;

    @Column(nullable = true)
    private LocalDateTime DateMaj;

    @Column(nullable = true)
    private LocalDateTime Date_Naissance;

    @Column(nullable = true, length = 128)
    private String Adresse;

    @Column(nullable = true, length = 2)
    private String IdStatus;

    @Column(nullable = true)
    private boolean Resident;

    @Column(nullable = true, length = 2)
    private String IdPays;

    @JoinColumn(name = "IdNatureAvoirs", nullable = true)
    @ManyToOne
    private NatureAvoir natureAvoir;

    @Column(nullable = true)
    private LocalDateTime DateOuverture;


}

