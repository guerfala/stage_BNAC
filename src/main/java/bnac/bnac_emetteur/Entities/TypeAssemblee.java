package bnac.bnac_emetteur.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name="TypeAssemblee")

public class TypeAssemblee {
    @Id
    @Column(nullable = false)
    private String IdTypeAssemblee;

    @Column(nullable = false)
    private String Libelle;
public TypeAssemblee(){}

    public TypeAssemblee(String type) {
        this.IdTypeAssemblee = type;
    }


}