package bnac.bnac_emetteur.Entities;

import java.io.Serializable;
import java.util.Objects;

public class PresentsId implements Serializable {

    private String matricule;
    private Emetteur emetteur;
    private TypeAssemblee typeAssemblee;

    // Default constructor
    public PresentsId() {}

    // Parameterized constructor
    public PresentsId(String matricule, Emetteur emetteur, TypeAssemblee typeAssemblee) {
        this.matricule = matricule;
        this.emetteur = emetteur;
        this.typeAssemblee = typeAssemblee;
    }

    // Getters and Setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Emetteur getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Emetteur emetteur) {
        this.emetteur = emetteur;
    }

    public TypeAssemblee getTypeAssemblee() {
        return typeAssemblee;
    }

    public void setTypeAssemblee(TypeAssemblee typeAssemblee) {
        this.typeAssemblee = typeAssemblee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresentsId that = (PresentsId) o;
        return Objects.equals(matricule, that.matricule) &&
                Objects.equals(emetteur, that.emetteur) &&
                Objects.equals(typeAssemblee, that.typeAssemblee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule, emetteur, typeAssemblee);
    }
}
