    package bnac.bnac_emetteur.DTO;

    import bnac.bnac_emetteur.Entities.Emetteur;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.LocalDate;
    import java.util.Date;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ImportDTO {
        private String adresse;
        private String cave;
        private String cavr;
        private String client;
        private String code_operation;
        private String codesisin;
        private LocalDate date_bourse;
        private LocalDate date_de_naissance;
        private LocalDate date_import;
        private LocalDate date_operation;
        private String identifiant;
        private String libelle;
        private String nationalite;
        private String nature_client;
        private String nature_compte;
        private String nature_comptee;
        private String nature_compter;
        private String nature_id;
        private String num_contrat;
        private int quantite;
        private String sens_comptable;
        private Double solde;
        private String statut;
        private String tc;
        private String tce;
        private String tcr;
        private String titre;
        private Boolean treated;
        private String type_client;
        private String type_de_residence;
        private String type_import;
        private String cav;
        private Emetteur emetteur;
    }

