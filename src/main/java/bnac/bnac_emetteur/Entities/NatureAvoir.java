package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NatureAvoir")

public class NatureAvoir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdNatureAvoirs", nullable = false)
    private int IdNatureAvoirs;

    @Column(name="Libelle", length =64,nullable = false)
    private String Libelle;

    @Column(name="CodeCategorieAvoir", length =3,nullable = false)
    private String CodeCategorieAvoir;


}
