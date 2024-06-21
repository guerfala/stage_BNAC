package bnac.bnac_emetteur.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoldeDTO {
    private int Matricule;
    private String RaisonSociale;
    private double prtage;
    private long solde;

}
