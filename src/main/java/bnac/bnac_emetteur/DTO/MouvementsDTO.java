package bnac.bnac_emetteur.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MouvementsDTO {
    private String libelleCourt;
    private Date dateBourse;
    private String actionnaire;
    private String numContrat;
    private int vente;
    private int achat;
    private float cours;
    private int idOperation;
    private int Solde;

    public MouvementsDTO(String libelleCourt, Date dateBourse, String actionnaire, String numContrat, int vente, int achat, float cours) {
        this.libelleCourt = libelleCourt;
        this.dateBourse = dateBourse;
        this.actionnaire = actionnaire;
        this.numContrat = numContrat;
        this.vente = vente;
        this.achat = achat;
        this.cours = cours;
    }

    public MouvementsDTO(String libelleCourt, Date dateBourse, int idOperation, String numContrat, int vente, int achat, float cours) {
        this.libelleCourt = libelleCourt;
        this.dateBourse = dateBourse;
        this.idOperation = idOperation;
        this.numContrat = numContrat;
        this.vente = vente;
        this.achat = achat;
        this.cours = cours;
    }
}
