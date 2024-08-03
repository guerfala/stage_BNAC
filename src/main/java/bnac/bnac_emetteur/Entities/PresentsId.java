package bnac.bnac_emetteur.Entities;

import java.io.Serializable;
import java.util.Objects;

public class PresentsId implements Serializable {

    private String matricule;
    private Long emetteur; // Matching the type of Emetteur entity's primary key
    private Long typeAssemblee; // Matching the type of TypeAssemblee entity's primary key

    // Default constructor
    public PresentsId() {}

    // Parameterized constructor
    public PresentsId(String matricule, Long emetteur, Long typeAssemblee) {
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

    public Long getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Long emetteur) {
        this.emetteur = emetteur;
    }

    public Long getTypeAssemblee() {
        return typeAssemblee;
    }

    public void setTypeAssemblee(Long typeAssemblee) {
        this.typeAssemblee = typeAssemblee;
    }

    // Override equals and hashCode
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
