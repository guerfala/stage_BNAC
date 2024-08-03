package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(PresentsId.class)
public class Presents implements Serializable {

    @Id
    @Column(name = "matricule")
    private String matricule;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_emetteur")
    private Emetteur emetteur;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_type_assemblee")
    private TypeAssemblee typeAssemblee;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "solde_matricule", referencedColumnName = "Matricule"),
            @JoinColumn(name = "solde_id_titre", referencedColumnName = "IdTitre"),
            @JoinColumn(name = "solde_id_tc", referencedColumnName = "IdTC"),
            @JoinColumn(name = "solde_id_nature_compte_titre", referencedColumnName = "IdNatureCompteTitre"),
            @JoinColumn(name = "solde_id_nature_avoirs", referencedColumnName = "IdNatureAvoirs")
    })
    private Solde_N solde;

    @Column(name = "type_presence")
    private String typePresence;

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

    public Solde_N getSolde() {
        return solde;
    }

    public void setSolde(Solde_N solde) {
        this.solde = solde;
    }

    public String getTypePresence() {
        return typePresence;
    }

    public void setTypePresence(String typePresence) {
        this.typePresence = typePresence;
    }
}
