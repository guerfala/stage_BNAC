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
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdOperation;

    private int Matricule;

    private String IdEmetteur;

    @Column(nullable = true)
    private String IdTC;

    @Column(nullable = true)
    private int IdNatureCompteTitre;

    @Column(nullable = true)
    private int IdNatureAvoirs;

    @Column(nullable = true)
    private String IdTC2;

    @Column(nullable = true)
    private int Matricule2;

    @Column(nullable = true)
    private String IdTitre;

    private String IdTypeOperation;

    private int Quantite;

    @Column(nullable = true)
    private float Cours;

    @Column(nullable = true)
    private LocalDateTime DateOperation;

    @Column(nullable = true)
    private LocalDateTime DateBourse;

    @Column(nullable = true)
    private String NumContrat;

    @Column(nullable = true)
    private String Creancier;

    @Column(nullable = true)
    private String RefOperation;

    @Column(nullable = true)
    private int IdUtilisateur;

    @Column(nullable = true)
    private boolean Comptabilisee;

    @Column(nullable = true)
    private boolean Pur;

    @Column(nullable = true)
    private String Parametre1;

    @Column(nullable = true)
    private String Parametre2;

    @Column(nullable = true)
    private String IdOperationBO;

    @Column(nullable = true)
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
