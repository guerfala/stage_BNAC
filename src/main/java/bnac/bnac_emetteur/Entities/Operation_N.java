package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation_N {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdOperation;

    @ManyToOne
    @JoinColumn(name="Matricule")
    private Actionnaire actionnaire;

    @JoinColumn(name = "IdEmetteur", nullable = false)
    @ManyToOne
    private Emetteur emetteur;

    @JoinColumn(name = "IdTC",nullable = true)
    @ManyToOne
    private TeneurCompte teneurCompte;

    @JoinColumn(name = "IdNatureCompteTitre", nullable = true)
    @ManyToOne
    private NatureCompteTitre natureCompteTitre;

    @JoinColumn(name = "IdNatureAvoirs", nullable = true)
    @ManyToOne
    private NatureAvoir natureAvoir;

    @JoinColumn(name = "IdTitre", nullable = true)
    @ManyToOne
    private Titre titre;

    @JoinColumn(name = "IdTypeOperation", nullable = true)
    @ManyToOne
    private TypeOperation typeOperation;

    @Column(nullable = false)
    private int Quantite;

    @Column(nullable = true)
    private float Cours;

    @Column(nullable = true)
    private LocalDateTime DateOperation;

    @Column(nullable = true)
    private LocalDateTime DateBourse;

    @Column(nullable = true, length = 16)
    private String NumContrat;

}
