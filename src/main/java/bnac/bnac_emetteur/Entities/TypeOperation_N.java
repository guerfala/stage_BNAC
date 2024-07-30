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
public class TypeOperation_N {

    @Id
    @Column(nullable = false, length = 4)
    private String IdTypeOperation;

    @Column(nullable = false, length = 64)
    private String Libelle;

    @Column(nullable = false)
    private float Sens;

    @Column(nullable = true, length = 4)
    private String IdTypeAnnulation;


    @Column(nullable = true)
    private boolean OperationOST;


    @Column(nullable = true)
    private Character Sens_Comptable;

    @Column(nullable = true, length = 5)
    private String CodeOperation;

    @Column(nullable = true, length = 3)
    private String CodeOperationCsd;

    @Column(nullable = true)
    private String LibelleCsd;
}
