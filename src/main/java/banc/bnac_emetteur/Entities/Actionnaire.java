package banc.bnac_emetteur.Entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Matricule;

    private String IdEmetteur;

    private String RaisonSociale;

    @Column(nullable = true)
    private int IdNatureAvoirs;

    @Column(nullable = true)
    private String Adresse;

    @Column(nullable = true)
    private String Ville;

    @Column(nullable = true)
    private String CodePostal;

    @Column(nullable = true)
    private int IdGenre;

    @Column(nullable = true)
    private String IdGroupe;

    @Column(nullable = true)
    private String Sexe;

    @Column(nullable = true)
    private String IdPays;

    @Column(nullable = true)
    private String IdNationalite;

    @Column(nullable = true)
    private String Email;

    @Column(nullable = true)
    private boolean Resident;

    @Column(nullable = true)
    private boolean SoldeConfirme;

    @Column(nullable = true)
    private String IdStatus;

    @Column(nullable = true)
    private String Identifiant;

    @Column(nullable = true)
    private String NaturePiece;

    @Column(nullable = true)
    private String CodeBO;

    @Column(nullable = true)
    private int TitreActionnaire;

    @Column(nullable = true)
    private int TitreConservation;

    @Column(nullable = true)
    private int TitreStico;

    @Column(nullable = true)
    private int IdAgence;

    @Column(nullable = true)
    private String RIB;

    @Column(nullable = true)
    private String CleAncienne;

    @Column(nullable = true)
    private LocalDateTime DateMaj;

    @Column(nullable = true)
    private boolean Annule;

    @Column(nullable = true)
    private String Profession;
}

