package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Assemblee")
@Getter
@Setter

public class Assemblee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int IdAssemblee;


    @OneToOne
    @JoinColumn(name = "IdTypeAssemblee", nullable = false)
    private TypeAssemblee typeAssemblee;

    @JoinColumn(name = "IdEmetteur", nullable = false)
    @ManyToOne
    private Emetteur emetteur;

    @Column(nullable = true)
    private LocalDateTime DateTenue;

    @Column(nullable = true)
    private String Lieu;

    @Column(nullable = true)
    private String Libelle;



}
