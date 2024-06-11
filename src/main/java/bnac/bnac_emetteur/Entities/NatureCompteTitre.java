package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="NatureCompteTitre")
@Data
public class NatureCompteTitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int IdNatureCompteTitre;

    @Column(length =64,nullable = false)
    private String Libelle;

    @Column(length =2,nullable = false)
    private String CodeNatureCompteTitre;

}
