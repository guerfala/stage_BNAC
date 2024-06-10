package bnac.bnac_emetteur.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Emetteur {
    @Id
    @Column(name = "IdEmetteur", length = 16, nullable = false)
    private String idEmetteur;

    @Column(name = "DerMatricule", nullable = false)
    private int derMatricule;

    @Column(name = "LibelleCourt", length = 16, nullable = false)
    private String libelleCourt;

    @Column(name = "LibelleLong", length = 64, nullable = false)
    private String libelleLong;

    @Column(name = "CodeStico", length = 6, nullable = false)
    private String codeStico;

    @Column(name = "Tel", length = 32)
    private String tel;

    @Column(name = "Fax", length = 16)
    private String fax;

    @Column(name = "Adresse", length = 64)
    private String adresse;

    @Column(name = "Ville", length = 32)
    private String ville;

    @Column(name = "CodePostal", length = 16)
    private String codePostal;

    @Column(name = "PremierResponsable", length = 64)
    private String premierResponsable;

    @Column(name = "Contact", length = 32)
    private String contact;

    @Column(name = "Email", length = 32)
    private String email;

    @Column(name = "DateMaj")
    private LocalDateTime dateMaj;

    @Column(name = "DateConvention")
    private LocalDateTime dateConvention;

    @Column(name = "Pourcentage")
    private Float pourcentage;





}
