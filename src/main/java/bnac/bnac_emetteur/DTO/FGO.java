package bnac.bnac_emetteur.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FGO {

    private String CodeBIC;
    private String CodeParticipant;
    private String NatureProp;
    private String Nom;
    private String Prenom;
    private String NomArabe;
    private String CodeNaturePiece;
    private String NumPiece;
    private LocalDate DateNaissance;
    private String CategorieInves;
    private String Secteur;
    private String Nationalite;
    private boolean Resident;
    private String Adresse;
    private String Ville;
    private String Gouvernorat;
    private String CodePostal;
    private String Tel;
    private String Fax;
    private String Email;
    private int RefOp;
    private LocalDate DateOp;
    private LocalDate DateComptable;
    private String CodeOp;
    private String SensOp;
    private String NumTransaction;
    private String CodeISIN;
    private String Vote;
    private String Dividende;
    private String Dententeurs;
    private String TypeCompte;
    private String SousCompte;
    private String CategorieAvoir;
    private int Quantite;
    private String CodeBICContrepartie;
    private String LegacyCodeContrepartie;
    private String Pays;
}
