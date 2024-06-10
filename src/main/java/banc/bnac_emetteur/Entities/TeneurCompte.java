package banc.bnac_emetteur.Entities;

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
    private String IdTC;

    private String LibelleCourt;

    private String LibelleLong;

    private String Tel;

    private String Fax;

    @Column(nullable = true)
    private String Adresse;

    @Column(nullable = true)
    private String CodePostal;

    @Column(nullable = true)
    private String Ville;

    @Column(nullable = true)
    private String Email;

    @Column(nullable = true)
    private String Contact;

    @Column(nullable = true)
    private String FonctionContact;

    @Column(nullable = true)
    private String PremierResponsable;

    @Column(nullable = true)
    private String FonctionPremierResponsable;

    @Column(nullable = true)
    private String CivilitePremierResponsable;

    @Column(nullable = true)
    private String IdEmetteur;

    @Column(nullable = true)
    private String CodeIAA;
}
