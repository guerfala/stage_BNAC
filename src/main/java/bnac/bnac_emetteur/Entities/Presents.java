package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "presents")
@IdClass(PresentsId.class)
@Getter
@Setter
public class Presents {
    @Id
    @Column(name = "IdPresent", nullable = false)
    private int IdPresent;

    @Id
    @Column(name = "idEmetteur", nullable = false)
    private String idEmetteur;

    @Id
    @Column(name = "IdTypeAssemblee")
    private String IdTypeAssemblee;

    @Id
    @Column(name = "Matricule", nullable = false)
    private int Matricule;

    @ManyToOne
    @JoinColumn(name = "idEmetteur", nullable = false, insertable = false, updatable = false)
    private Emetteur emetteur;

    @ManyToOne
    @JoinColumn(name = "IdTypeAssemblee", insertable = false, updatable = false)
    private TypeAssemblee typeAssemblee;

    @ManyToOne
    @JoinColumn(name = "Matricule", nullable = false, insertable = false, updatable = false)
    private Actionnaire_N actionnaire;

    @Column(name = "date_tenue")
    private Date dateTenue;
}
