package bnac.bnac_emetteur.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionnaireDTO {
    private int Matricule;
    private String RaisonSociale;
    private String Identifiant;
    private String LibelleCourt;
    private int Solde;
    private String CodeNatureCompteTitre;
    private String CodeCategorieAvoir;
    private String Adresse;
    private String IdPays;
    private String NaturePiece;

    // Constructor for the first query
    public ActionnaireDTO(int Matricule, String RaisonSociale, String Identifiant, String LibelleCourt, int Solde, String CodeNatureCompteTitre, String CodeCategorieAvoir, String Adresse) {
        this.Matricule = Matricule;
        this.RaisonSociale = RaisonSociale;
        this.Identifiant = Identifiant;
        this.LibelleCourt = LibelleCourt;
        this.Solde = Solde;
        this.CodeNatureCompteTitre = CodeNatureCompteTitre;
        this.CodeCategorieAvoir = CodeCategorieAvoir;
        this.Adresse = Adresse;
    }

    // Constructor for the other queries
    public ActionnaireDTO(int Matricule, String RaisonSociale, String IdPays, String Identifiant, String NaturePiece, String LibelleCourt, String CodeNatureCompteTitre, String CodeCategorieAvoir, int Solde) {
        this.Matricule = Matricule;
        this.RaisonSociale = RaisonSociale;
        this.IdPays = IdPays;
        this.Identifiant = Identifiant;
        this.NaturePiece = NaturePiece;
        this.LibelleCourt = LibelleCourt;
        this.CodeNatureCompteTitre = CodeNatureCompteTitre;
        this.CodeCategorieAvoir = CodeCategorieAvoir;
        this.Solde = Solde;
    }
}
