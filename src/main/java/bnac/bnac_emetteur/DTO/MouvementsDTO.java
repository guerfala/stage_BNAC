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
}
