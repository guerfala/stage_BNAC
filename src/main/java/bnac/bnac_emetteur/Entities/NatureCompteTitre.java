package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="NatureCompteTitre")
public class NatureCompteTitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int IdNatureCompteTitre;

    @Column(length =64,nullable = false)
    private String Libelle;

    @Column(name="CodeNatureCompteTitre", length =2,nullable = false)
    private String CodeNatureCompteTitre;

}
