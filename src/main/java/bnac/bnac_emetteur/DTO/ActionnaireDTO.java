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
}
