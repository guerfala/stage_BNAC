package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeneurCompte {

    @Id
    @Column(nullable = false, length = 3)
    private String IdTC;

    @Column(nullable = false, length = 16)
    private String LibelleCourt;

    @Column(nullable = false, length = 32)
    private String LibelleLong;

    @Column(nullable = true, length = 32)
    private String Tel;

    @Column(nullable = true, length = 16)
    private String Fax;

    @Column(nullable = true, length = 64)
    private String Adresse;

    @Column(nullable = true, length = 16)
    private String CodePostal;

    @Column(nullable = true, length = 32)
    private String Ville;

    @Column(nullable = true, length = 32)
    private String Email;

    @Column(nullable = true, length = 64)
    private String Contact;

    @Column(nullable = true, length = 32)
    private String FonctionContact;

    @Column(nullable = true, length = 64)
    private String PremierResponsable;

    @Column(nullable = true, length = 32)
    private String FonctionPremierResponsable;

    @Column(nullable = true, length = 8)
    private String CivilitePremierResponsable;

    @Column(nullable = true, length = 16)
    private String IdEmetteur;

    @Column(nullable = true, length = 3)
    private String CodeIAA;

    @Column(nullable = true)
    private String LibelleCsd;

    @Column(nullable = true)
    private String CodeSwift;

}
