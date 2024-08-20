package bnac.bnac_emetteur.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FCRA {

    private String NumLigne;
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
    private String Resident;
    private String Adresse;
    private String Ville;
    private String Gouvernorat;
    private String CodePostal;
    private String Tel;
    private String Fax;
    private String Pays;
    private String Email;
    private String CodeISIN;
    private String Vote;
    private String Dividend;
    private String Rights;
    private String TypeCompte;
    private String SousCompte;
    private String CategorieAvoir;
    private String Quantite;
    private LocalDate DateComptable;
}
