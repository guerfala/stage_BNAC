package bnac.bnac_emetteur.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SoldePk implements Serializable {

    private int Matricule;
    private String IdTitre;
    private String IdTC;
    private int IdNatureCompteTitre;
    private int IdNatureAvoirs;

    // Getters and Setters
    // ...

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(Matricule, IdTitre, IdTC, IdNatureCompteTitre, IdNatureAvoirs);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SoldePk that = (SoldePk) obj;
        return Objects.equals(Matricule, that.Matricule) &&
                Objects.equals(IdTitre, that.IdTitre) &&
                Objects.equals(IdTC, that.IdTC) &&
                Objects.equals(IdNatureCompteTitre, that.IdNatureCompteTitre) &&
                Objects.equals(IdNatureAvoirs, that.IdNatureAvoirs);
    }
}
