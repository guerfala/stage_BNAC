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
public class Actionnaire {

    @Id
    private int Matricule;

    @JoinColumn(name = "IdEmetteur", nullable = false)
    @ManyToOne
    private Emetteur emetteur;

    @Column(nullable = false, length = 128)
    private String RaisonSociale;

    @JoinColumn(name = "IdNatureAvoirs", nullable = true)
    @ManyToOne
    private NatureAvoir natureAvoir;

    @Column(nullable = true, length = 128)
    private String Adresse;

    @Column(nullable = true, length = 32)
    private String Ville;

    @Column(nullable = true, length = 16)
    private String CodePostal;

    @Column(nullable = true)
    private int IdGenre;

    @Column(nullable = true, length = 8)
    private String IdGroupe;

    @Column(nullable = true, length = 1)
    private String Sexe;

    @Column(nullable = true, length = 2)
    private String IdPays;

    @Column(nullable = true, length = 2)
    private String IdNationalite;

    @Column(nullable = true, length = 64)
    private String Email;

    @Column(nullable = true)
    private boolean Resident;

    @Column(nullable = true)
    private boolean SoldeConfirme;

    @Column(nullable = true, length = 2)
    private String IdStatus;

    @Column(nullable = true, length = 16)
    private String Identifiant;

    @Column(nullable = true, length = 32)
    private String NaturePiece;

    @Column(nullable = true, length = 64)
    private String CodeBO;

    @Column(nullable = true)
    private int TitreActionnaire;

    @Column(nullable = true)
    private int TitreConservation;

    @Column(nullable = true)
    private int TitreStico;

    @Column(nullable = true)
    private int IdAgence;

    @Column(nullable = true, length = 32)
    private String RIB;

    @Column(nullable = true, length = 32)
    private String CleAncienne;

    @Column(nullable = true)
    private LocalDateTime DateMaj;

    @Column(nullable = true)
    private boolean Annule;

    @Column(nullable = true, length = 64)
    private String Profession;
}

