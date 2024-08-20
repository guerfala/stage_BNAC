package bnac.bnac_emetteur.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class  Emetteur {
    @Id
    @Column( length = 16, nullable = false)
    private String idEmetteur;

    @Column(nullable = false)
    private int derMatricule;

    @Column(length = 16, nullable = false)
    private String libelleCourt;

    @Column(length = 64, nullable = false)
    private String libelleLong;

    @Column(length = 6, nullable = false)
    private String codeStico;

    @Column(length = 32)
    private String tel;

    @Column(length = 16)
    private String fax;

    @Column(length = 64)
    private String adresse;

    @Column(length = 32)
    private String ville;

    @Column(length = 16)
    private String codePostal;

    @Column(length = 64)
    private String premierResponsable;

    @Column(length = 32)
    private String contact;

    @Column(length = 32)
    private String email;


    private LocalDateTime dateMaj;


    private LocalDateTime dateConvention;

    private Float pourcentage;


    public Emetteur(String type) {
        this.idEmetteur = type;
    }



}
