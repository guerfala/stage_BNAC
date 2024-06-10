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
    @Column(nullable = false)
    private int IdNatureAvoirs;

    @Column(length =64,nullable = false)
    private String Libelle;

    @Column(length =3,nullable = false)
    private String CodeCategorieAvoir;


}
