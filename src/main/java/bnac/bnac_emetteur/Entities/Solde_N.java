package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="Solde_N")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SoldePk.class)
public class Solde_N {

    @Id
    @Column(name = "Matricule", nullable = false)
    private int Matricule;

    @Id
    @Column(name = "IdTitre", nullable = false, length =8)
    private String IdTitre;

    @Id
    @Column(name = "IdTC", nullable = false, length = 3)
    private String IdTC;

    @Id
    @Column(name = "IdNatureCompteTitre", nullable = false)
    private int IdNatureCompteTitre;

    @Id
    @Column(name = "IdNatureAvoirs", nullable = false)
    private int IdNatureAvoirs;

    @ManyToOne
    @JoinColumn(name = "Matricule", insertable = false, updatable = false)
    private Actionnaire actionnaire;

    @ManyToOne
    @JoinColumn(name = "IdTitre", insertable = false, updatable = false)
    private Titre titre;

    @ManyToOne
    @JoinColumn(name = "IdTC", insertable = false, updatable = false)
    private TeneurCompte teneurCompte;

    @ManyToOne
    @JoinColumn(name = "IdNatureCompteTitre", insertable = false, updatable = false)
    private NatureCompteTitre natureCompteTitre;

    @ManyToOne
    @JoinColumn(name = "IdNatureAvoirs", insertable = false, updatable = false)
    private NatureAvoir natureAvoir;

    @Column(nullable=false)
    private int Solde;

    @Column(nullable = false)
    private LocalDateTime dateMaj;


}
