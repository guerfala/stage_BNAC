package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Entity
@IdClass(PresentsId.class)
public class Presents implements Serializable {

    // Getters and Setters
    @Id
    @Column(name = "matricule")
    private String matricule;

    @Id
    @ManyToOne
    @JoinColumn(name = "idEmetteur", referencedColumnName = "idEmetteur")
    private Emetteur emetteur;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdTypeAssemblee", referencedColumnName = "IdTypeAssemblee")
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

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setEmetteur(Emetteur emetteur) {
        this.emetteur = emetteur;
    }

    public void setTypeAssemblee(TypeAssemblee typeAssemblee) {
        this.typeAssemblee = typeAssemblee;
    }

    public void setSolde(Solde_N solde) {
        this.solde = solde;
    }

    public void setTypePresence(String typePresence) {
        this.typePresence = typePresence;
    }
}
