package bnac.bnac_emetteur.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Import {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Import;

    @Column(nullable = true, length = 64)
    private String Libelle;      //type_operation_N

    @Column(nullable = true)
    private String SensComptable;     //type_operation_N

    @Column(nullable = true, length = 5)
    private String CodeOperation;   //type_operation_N

    @Column(length =16,nullable = true)
    private String CodeSISIN;   //titre

    @Column(nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate DateOperation;

    @Column(nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate DateImport;

    @Column(nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate DateBourse;

    @Column(nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate DateDeNaissance;


    @Column(nullable = true, length = 16)
    private String NumContrat; //Operation_N

    @Column(length =3,nullable = true)
    private String CAVE; //codeCategorieAvoir men natureAvoir

    @Column(length =3,nullable = true)
    private String CAVR; //codeCategorieAvoir men natureAvoir


    @Column(length =25,nullable = true)
    private String Nature_CompteE; //Sous_CompteE


    @Column(length =25,nullable = true)
    private String Nature_CompteR; //Sous_CompteR

    @Column(length =255,nullable = true)
    private String Client;

    @Column(nullable=true)
    private int Quantite;

    @Column(length =255,nullable = true)
    private String TypeClient;

    @Column(length =255,nullable = true)
    private String Nature_id;

    @Column(nullable = true)
    private String Identifiant;

    @Column(nullable = true, length = 25)
    private String Nationalite;

    @Column(nullable = true, length = 255)
    private String Adresse;

    @Column(nullable = true, length = 25)
    private String Statut;

    @Column(nullable = true, length = 4)
    private String Type_import;

    @Column(nullable = true)
    private boolean Treated;

    @JoinColumn(name = "IdEmetteur", nullable = false)
    @ManyToOne
    private Emetteur emetteur;

    @Column(nullable = true)
    private String TypeDeResidence;

    @Column(nullable = true)
    private String TC;

    @Column(nullable = true)
    private Double Solde;

    @Column(nullable = true)
    private String cav;

    @Column(nullable = true)
    private String NatureCompte;

    @Column(nullable = true)
    private String TCR;  //TCRecepteur

    @Column(nullable = true)
    private String TCE;  //TCEmetteur

    @Column(nullable = true)
    private String NatureClient;

    @JoinColumn(name = "IdTitre", nullable = false)
    @ManyToOne
    private Titre Titre;



}
