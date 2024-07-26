package bnac.bnac_emetteur.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    @Id
    @Column( length = 16, nullable = false)
    private String idStatus;

    private String Libelle;

    private String CodeNatureActionnaire;

    @Column(length =20,nullable = true)
    private String codeTunCl;
}
