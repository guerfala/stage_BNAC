package bnac.bnac_emetteur.Entities;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class PresentsId implements Serializable {
    private String idEmetteur;
    private String IdTypeAssemblee;
    private int Matricule;
    private int IdPresent;

//    @Override
//    public int hashCode() {
//        return Objects.hash(Matricule, idEmetteur, IdTypeAssemblee,IdPresent);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        PresentsId that = (PresentsId) obj;
//        return Objects.equals(Matricule, that.Matricule) &&
//                Objects.equals(idEmetteur, that.idEmetteur) &&
//                Objects.equals(IdTypeAssemblee, that.IdTypeAssemblee) ;
//
//    }
}
