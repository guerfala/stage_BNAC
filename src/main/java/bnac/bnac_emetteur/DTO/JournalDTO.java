package bnac.bnac_emetteur.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalDTO {
    private String tc;
    private Date dateBourse;
    private String type;
    private String raisonSociale;
    private String idTitre;
    private String numContrat;
    private int debit;
    private int credit;
}
