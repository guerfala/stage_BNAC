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
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdOperation;

    @ManyToOne
    @JoinColumn(name="Matricule")
    private Actionnaire actionnaire;

    @JoinColumn(name = "IdEmetteur", nullable = false)
    @ManyToOne
    private Emetteur emetteur;

    @JoinColumn(name = "IdTC",nullable = true)
    @ManyToOne
    private TeneurCompte teneurCompte;

    @JoinColumn(name = "IdNatureCompteTitre", nullable = true)
    @ManyToOne
    private NatureCompteTitre natureCompteTitre;

    @JoinColumn(name = "IdNatureAvoirs", nullable = true)
    @ManyToOne
    private NatureAvoir natureAvoir;

    @Column(nullable = true, length = 3)
    private String IdTC2;

    @Column(nullable = true)
    private int Matricule2;

    @JoinColumn(name = "IdTitre", nullable = true)
    @ManyToOne
    private Titre titre;

    @JoinColumn(name = "IdTypeOperation", nullable = true)
    @ManyToOne
    private TypeOperation typeOperation;

    @Column(nullable = false)
    private int Quantite;

    @Column(nullable = true)
    private float Cours;

    @Column(nullable = true)
    private LocalDateTime DateOperation;

    @Column(nullable = true)
    private LocalDateTime DateBourse;

    @Column(nullable = true, length = 16)
    private String NumContrat;

    @Column(nullable = true, length = 32)
    private String Creancier;

    @Column(nullable = true, length = 32)
    private String RefOperation;

    @Column(nullable = true)
    private int IdUtilisateur;

    @Column(nullable = true)
    private boolean Comptabilisee;

    @Column(nullable = true)
    private boolean Pur;

    @Column(nullable = true, length = 1)
    private String Parametre1;

    @Column(nullable = true, length = 1)
    private String Parametre2;

    @Column(nullable = true, length = 16)
    private String IdOperationBO;

    @Column(nullable = true, length = 16)
    private String IdEmprunt;

    @Column(nullable = true)
    private int IdOSTTCLT;

    @Column(nullable = true)
    private int RestantDu;

    @Column(nullable = true)
    private int Principal;

    @Column(nullable = true)
    private float InteretBrut;

    @Column(nullable = true)
    private float RS;

    @Column(nullable = true)
    private float MontantNet;

    @Column(nullable = true)
    private int Duree;
}
