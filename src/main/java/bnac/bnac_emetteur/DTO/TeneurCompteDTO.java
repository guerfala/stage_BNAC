package bnac.bnac_emetteur.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeneurCompteDTO {
    private String idTC;
    private String libelleCourt;
    private String codeNatureCompteTitre;
    private String libelleNC;
    private String codeCategorieAvoir;
    private String libelleNa;
    private Long solde;
}
