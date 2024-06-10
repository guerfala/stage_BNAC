package bnac.bnac_emetteur.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Titre")

public class Titre {
    @Id
    @Column(name="IdTitre", length =8,nullable = false)
    private String IdTitre;

    @Column(name="LibelleCourt", length =16,nullable = false)
    private String LibelleCourt;

    @Column(name="LibelleLong", length =64,nullable = false)
    private String LibelleLong;

    @Column(name="IdCategorieTitre", length =4,nullable = false)
    private String IdCategorieTitre;

    @Column(name="Nominal",nullable = false)
    private int Nominal;

    @Column(name="Nombre",nullable = false)
    private int Nombre;

    @Column(name="Pourcentage",nullable = false)
    private float Pourcentage ;

    @Column(name="CodeStico", length =6,nullable = false)
    private String CodeStico;

    @Column(name="CodeSISIN", length =16,nullable = false)
    private String CodeSISIN;

    @Column(name="MatriculeDroitNonConverti",nullable = false)
    private String MatriculeDroitNonConverti;


    @Column(name="MatriculeDroitConverti",nullable = false)
    private String MatriculeDroitConverti;




}
