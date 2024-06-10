package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Titre")

public class Titre {
    @Id
    @Column(length =8,nullable = false)
    private String IdTitre;

    @Column(length =16,nullable = false)
    private String LibelleCourt;

    @Column(length =64,nullable = false)
    private String LibelleLong;

    @Column(length =4,nullable = false)
    private String IdCategorieTitre;

    @Column(nullable = false)
    private int Nominal;

    @Column(nullable = false)
    private int Nombre;

    @Column(nullable = false)
    private float Pourcentage ;

    @Column(length =6,nullable = false)
    private String CodeStico;

    @Column(length =16,nullable = false)
    private String CodeSISIN;

    @Column(nullable = false)
    private String MatriculeDroitNonConverti;


    @Column(nullable = false)
    private String MatriculeDroitConverti;

    @JoinColumn(name="IdEmetteur")
    @ManyToOne
    private Emetteur emetteur;

}
