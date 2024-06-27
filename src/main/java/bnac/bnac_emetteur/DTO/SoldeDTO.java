package bnac.bnac_emetteur.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoldeDTO {
    private int Matricule;
    private String RaisonSociale;
    private double prtage;
    private long solde;

    public SoldeDTO(int Matricule, String RaisonSociale, long solde) {
        this.Matricule = Matricule;
        this.RaisonSociale = RaisonSociale;
        this.solde = solde;
    }

}
