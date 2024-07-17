package bnac.bnac_emetteur.DTO;

import bnac.bnac_emetteur.Entities.Emetteur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportDTO {
    private String adresse;
    private String cave;
    private String cavr;
    private String client;
    private String codeOperation;
    private String codeSisin;
    private Date dateBourse;
    private Date dateDeNaissance;
    private Date dateImport;
    private Date dateOperation;
    private String identifiant;
    private String libelle;
    private String nationalite;
    private String natureClient;
    private String natureCompte;
    private String natureComptee;
    private String natureCompter;
    private String natureId;
    private String numContrat;
    private int quantite;
    private float sensComptable;
    private Double solde;
    private String statut;
    private String tc;
    private String tce;
    private String tcr;
    private String titre;
    private Boolean treated;
    private String typeClient;
    private String typeDeResidence;
    private String typeImport;
    private String cav;
    private Emetteur emetteur;
}

