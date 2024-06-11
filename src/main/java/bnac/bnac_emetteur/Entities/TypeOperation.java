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
public class TypeOperation {

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
    private boolean Acomptabiliser;

    @Column(nullable = true)
    private boolean OperationOST;

    @Column(nullable = true, length = 4)
    private String IdOrigineOperation;

    @Column(nullable = true)
    private float SensN;

    @Column(nullable = true)
    private float SensO;

    @Column(nullable = true)
    private boolean OperationDivers;

    @Column(nullable = true, length = 5)
    private String CodeOperation;
}
