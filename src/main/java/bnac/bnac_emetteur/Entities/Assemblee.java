package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.security.PublicKey;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Assemblee")
@Setter
@Getter

public class Assemblee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int IdAssemblee;


    @ManyToOne
    @JoinColumn(name = "IdTypeAssemblee")
        private TypeAssemblee typeAssemblee;

    @ManyToOne
    @JoinColumn(name="IdEmetteur")
    private Emetteur emetteur;

    @Column(nullable = true)
    private LocalDateTime DateTenue;

    @Column(nullable = true)
    private String Lieu;

    @Column(nullable = true)
    private String Libelle;
    @Transient
    public String getIdEmetteur() {
        return emetteur != null ? emetteur.getIdEmetteur() : null;
    }

    @Transient
    public String getIdTypeAseemblee()
    {
        return typeAssemblee != null ? typeAssemblee.getIdTypeAssemblee() : null;


}
}