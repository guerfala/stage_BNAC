package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Import")
public class Import {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Import;

    @Column(nullable = true, length = 64)
    private String Libelle;      //type_operation_N

    @Column(nullable = true)
    private float SensComptable;     //type_operation_N

    @Column(nullable = true, length = 5)
    private String CodeOperation;   //type_operation_N

    @Column(length =16,nullable = false)
    private String CodeSISIN;   //titre

    @Column(nullable = true)
    private Date DateOperation; //Operation_N

    @Column(nullable = true)
    private Date DateImport;

    @Column(nullable = true)
    private Date DateBourse;  //Operation_N

    @Column(nullable = true, length = 16)
    private String NumContrat; //Operation_N

    @Column(length =3,nullable = false)
    private String CAVE; //codeCategorieAvoir men natureAvoir

    @Column(length =3,nullable = false)
    private String CAVR; //codeCategorieAvoir men natureAvoir


    @Column(length =25,nullable = false)
    private String Nature_CompteE; //Sous_CompteE


    @Column(length =25,nullable = false)
    private String Nature_CompteR; //Sous_CompteR

    @Column(length =255,nullable = false)
    private String Client;

    @Column(nullable=false)
    private int Quantite;

    @Column(length =255,nullable = false)
    private String TypeClient;

    @Column(length =255,nullable = false)
    private String Nature_id;

    @Column(nullable = true, length = 16)
    private String Identifiant;

    @Column(nullable = true, length = 25)
    private String Nationalite;

    @Column(nullable = true, length = 255)
    private String Adresse;

    @Column(nullable = true, length = 25)
    private String Statut;

    @Column(nullable = true, length = 4)
    private String Type_import;

    @Column(nullable = false)
    private boolean Treated;

    @JoinColumn(name = "IdEmetteur", nullable = false)
    @ManyToOne
    private Emetteur emetteur;

    @Column(nullable = true)
    private Date DateDeNaissance;

    @Column(nullable = true)
    private String TypeDeResidence;

    @Column(nullable = true)
    private String TC;

    @Column(nullable = true)
    private Double Solde;

    @Column(nullable = false)
    private String cav;

    @Column(nullable = true)
    private String NatureCompte;

    @Column(nullable = true)
    private String TCR;  //TCRecepteur

    @Column(nullable = true)
    private String TCE;  //TCEmetteur

    @Column(nullable = true)
    private String NatureClient;

    @Column(nullable = true)
    private String Titre;



}
