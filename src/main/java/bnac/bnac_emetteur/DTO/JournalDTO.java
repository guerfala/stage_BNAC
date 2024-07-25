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
    private int idOp;

    public JournalDTO(String tc, Date dateBourse, String type, String raisonSociale, String idTitre, String numContrat, int debit, int credit) {
        this.tc = tc;
        this.dateBourse = dateBourse;
        this.type = type;
        this.raisonSociale = raisonSociale;
        this.idTitre = idTitre;
        this.numContrat = numContrat;
        this.debit = debit;
        this.credit = credit;
    }

    public JournalDTO(String tc, Date dateBourse, String type, int idOp, String numContrat, int debit, int credit) {
        this.tc = tc;
        this.dateBourse = dateBourse;
        this.type = type;
        this.idOp = idOp;
        this.numContrat = numContrat;
        this.debit = debit;
        this.credit = credit;
    }
}
