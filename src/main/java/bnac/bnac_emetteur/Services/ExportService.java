package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.DTO.FCRA;
import bnac.bnac_emetteur.DTO.FGO;
import bnac.bnac_emetteur.Repositories.OperationNRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExportService {

    @Autowired
    private OperationNRepo exportRepo;

    public ByteArrayInputStream getRegFileData(String emetteurId, String titreId, LocalDate minDate, LocalDate maxDate) throws IOException {
        List<FGO> fgos = exportRepo.getFGO(emetteurId, titreId, minDate, maxDate);
        String regFileContent = generateRegFileContent(fgos);
        return new ByteArrayInputStream(regFileContent.getBytes());
    }

    private String generateRegFileContent(List<FGO> fgos) {
        StringBuilder regContent = new StringBuilder();

        int rowIndex = 1;

        for (FGO fgo : fgos) {

            fgo.setNumLigne(String.valueOf(rowIndex));

            applyRestrictionsFGO(fgo);

            regContent.append(fgo.getNumLigne());
            regContent.append(fgo.getCodeBIC());
            regContent.append(fgo.getCodeParticipant());
            regContent.append(fgo.getNatureProp());
            regContent.append(fgo.getNom());
            regContent.append(fgo.getPrenom());
            regContent.append(fgo.getNomArabe());
            regContent.append(fgo.getCodeNaturePiece());
            regContent.append(fgo.getNumPiece());
            regContent.append(fgo.getDateNaissance());
            regContent.append(fgo.getCategorieInves());
            regContent.append(fgo.getSecteur());
            regContent.append(fgo.getNationalite());
            regContent.append(fgo.getResident());
            regContent.append(fgo.getAdresse());
            regContent.append(fgo.getVille());
            regContent.append(fgo.getGouvernorat());
            regContent.append(fgo.getCodePostal());
            regContent.append(fgo.getTel());
            regContent.append(fgo.getFax());
            regContent.append(fgo.getEmail());
            regContent.append(fgo.getRefOp());
            regContent.append(fgo.getDateOp());
            regContent.append(fgo.getDateComptable());
            regContent.append(fgo.getCodeOp());
            regContent.append(fgo.getSensOp());
            regContent.append(fgo.getNumTransaction());
            regContent.append(fgo.getCodeISIN());
            regContent.append(fgo.getVote());
            regContent.append(fgo.getDividende());
            regContent.append(fgo.getDententeurs());
            regContent.append(fgo.getTypeCompte());
            regContent.append(fgo.getSousCompte());
            regContent.append(fgo.getCategorieAvoir());
            regContent.append(fgo.getQuantite());
            regContent.append(fgo.getCodeBICContrepartie());
            regContent.append(fgo.getLegacyCodeContrepartie());
            regContent.append(fgo.getPays()).append("\n");

            rowIndex++;
        }

        return regContent.toString();
    }

    public ByteArrayInputStream getRegFileDataFCRA(String emetteurId, String titreId, LocalDateTime minDate, LocalDateTime maxDate) throws IOException {
        List<FCRA> fcras = exportRepo.getFCRA(emetteurId, titreId, minDate, maxDate);
        String regFileContent = generateRegFileContentFCRA(fcras);
        return new ByteArrayInputStream(regFileContent.getBytes());
    }

    private String generateRegFileContentFCRA(List<FCRA> fcras) {
        StringBuilder regContent = new StringBuilder();

        int rowIndex = 1;

        for (FCRA fcra : fcras) {

            fcra.setNumLigne(String.valueOf(rowIndex));

            applyRestrictionsFCRA(fcra);

            regContent.append(fcra.getNumLigne());
            regContent.append(fcra.getCodeBIC());
            regContent.append(fcra.getCodeParticipant());
            regContent.append(fcra.getNatureProp());
            regContent.append(fcra.getNom());
            regContent.append(fcra.getPrenom());
            regContent.append(fcra.getNomArabe());
            regContent.append(fcra.getCodeNaturePiece());
            regContent.append(fcra.getNumPiece());
            regContent.append(fcra.getDateNaissance());
            regContent.append(fcra.getCategorieInves());
            regContent.append(fcra.getSecteur());
            regContent.append(fcra.getNationalite());
            regContent.append(fcra.getResident());
            regContent.append(fcra.getAdresse());
            regContent.append(fcra.getVille());
            regContent.append(fcra.getGouvernorat());
            regContent.append(fcra.getCodePostal());
            regContent.append(fcra.getTel());
            regContent.append(fcra.getFax());
            regContent.append(fcra.getPays());
            regContent.append(fcra.getEmail());
            regContent.append(fcra.getCodeISIN());
            regContent.append(fcra.getVote());
            regContent.append(fcra.getDividend());
            regContent.append(fcra.getRights());
            regContent.append(fcra.getTypeCompte());
            regContent.append(fcra.getSousCompte());
            regContent.append(fcra.getCategorieAvoir());
            regContent.append(fcra.getQuantite());
            regContent.append(fcra.getDateComptable()).append("\n");

            rowIndex++;
        }

        return regContent.toString();
    }

    public void applyRestrictionsFGO(FGO fgo) {
        if (fgo.getNumLigne() != null) {
            fgo.setNumLigne(String.format("%05d", Integer.parseInt(fgo.getNumLigne())));
        }

        if (fgo.getCodeBIC() != null) {
            fgo.setCodeBIC(String.format("%-11s", fgo.getCodeBIC()));
        }

        if (fgo.getCodeParticipant() != null) {
            fgo.setCodeParticipant(String.format("%03d", Integer.parseInt(fgo.getCodeParticipant())));
        }

        if (fgo.getNatureProp() != null) {
            fgo.setNatureProp(String.format("%-2s", fgo.getNatureProp()));
        }

        if (fgo.getNom() != null) {
            fgo.setNom(String.format("%-100s", fgo.getNom()));
        }

        if (fgo.getPrenom() != null) {
            fgo.setPrenom(String.format("%-100s", fgo.getPrenom()));
        }

        if (fgo.getNomArabe() != null) {
            fgo.setNomArabe(String.format("%-200s", fgo.getNomArabe()));
        }

        if (fgo.getCodeNaturePiece() != null) {
            switch (fgo.getCodeNaturePiece()) {
                case "CIN" -> fgo.setCodeNaturePiece("CI");
                case "Indéfini" -> fgo.setCodeNaturePiece("01");
                case "Carte de Séjour" -> fgo.setCodeNaturePiece("CS");
                case "Passeport" -> fgo.setCodeNaturePiece("PS");
                default -> fgo.setCodeNaturePiece("UI");
            }
        }

        if (fgo.getNumPiece() != null) {
            fgo.setNumPiece(String.format("%020d", Long.parseLong(fgo.getNumPiece())));
        }

        if (fgo.getCategorieInves() != null) {
            fgo.setCategorieInves(String.format("%-2s", fgo.getCategorieInves()));
        }

        if (fgo.getSecteur() != null) {
            fgo.setSecteur(String.format("%-2s", fgo.getSecteur()));
        }

        if (fgo.getNationalite() != null) {
            fgo.setNationalite(String.format("%-2s", fgo.getNationalite()));
        }

        if (fgo.getDateNaissance() == null) {
            fgo.setDateNaissance(LocalDate.of(1960,1,1));
        }

        if (fgo.getAdresse() != null) {
            fgo.setAdresse(String.format("%-100s", fgo.getAdresse()));
        }

        if (fgo.getVille() != null) {
            fgo.setVille(String.format("%-50s", fgo.getVille()));
        }

        if (fgo.getGouvernorat() != null) {
            fgo.setGouvernorat(String.format("%-50s", fgo.getGouvernorat()));
        }

        if (fgo.getCodePostal() != null) {
            fgo.setCodePostal(String.format("%-20s", fgo.getCodePostal()));
        }

        if (fgo.getTel() != null) {
            fgo.setTel(String.format("%-20s", fgo.getTel()));
        }

        if (fgo.getFax() != null) {
            fgo.setFax(String.format("%-20s", fgo.getFax()));
        }

        if (fgo.getEmail() != null) {
            fgo.setEmail(String.format("%-50s", fgo.getEmail()));
        }

        if (fgo.getRefOp() != null) {
            fgo.setRefOp(String.format("%07d", Integer.parseInt(fgo.getRefOp())));
        }

        if (fgo.getCodeOp() != null) {
            fgo.setCodeOp(String.format("%-2s", fgo.getCodeOp()));
        }

        if (fgo.getSensOp() != null) {
            fgo.setSensOp(String.format("%-1s", fgo.getSensOp()));
        }

        if (fgo.getNumTransaction() != null) {
            fgo.setNumTransaction(String.format("%-10s", fgo.getNumTransaction()));
        }

        if (fgo.getCodeISIN() != null) {
            fgo.setCodeISIN(String.format("%-12s", fgo.getCodeISIN()));
        }

        if (fgo.getVote() != null) {
            fgo.setVote(String.format("%-10s", fgo.getVote()));
        }

        if (fgo.getDividende() != null) {
            fgo.setDividende(String.format("%-10s", fgo.getDividende()));
        }

        if (fgo.getDententeurs() != null) {
            fgo.setDententeurs(String.format("%-10s", fgo.getDententeurs()));
        }

        if (fgo.getTypeCompte() != null) {
            fgo.setTypeCompte(String.format("%-1s", fgo.getTypeCompte()));
        }

        if (fgo.getSousCompte() != null) {
            fgo.setSousCompte(String.format("%-2s", fgo.getSousCompte()));
        }

        if (fgo.getCategorieAvoir() != null) {
            fgo.setCategorieAvoir(String.format("%03d", Integer.parseInt(fgo.getCategorieAvoir())));
        }

        if (fgo.getQuantite() != null) {
            fgo.setQuantite(String.format("%012d", Integer.parseInt(fgo.getQuantite())));
        }

        if (fgo.getCodeBICContrepartie() != null) {
            fgo.setCodeBICContrepartie(String.format("%-11s", fgo.getCodeBICContrepartie()));
        }

        if (fgo.getLegacyCodeContrepartie() != null) {
            fgo.setLegacyCodeContrepartie(String.format("%-3s", fgo.getLegacyCodeContrepartie()));
        }

        if (fgo.getPays() != null) {
            fgo.setPays(String.format("%-2s", fgo.getPays()));
        }

        if (fgo.getPays() != null) {
            fgo.setPays(String.format("%-2s", fgo.getPays()));
        }
    }

    public void applyRestrictionsFCRA(FCRA fcra) {

        if (fcra.getNumLigne() != null) {
            fcra.setNumLigne(String.format("%05d", Integer.parseInt(fcra.getNumLigne())));
        }

        if (fcra.getCodeBIC() != null) {
            fcra.setCodeBIC(String.format("%-11s", fcra.getCodeBIC()));
        }

        if (fcra.getCodeParticipant() != null) {
            fcra.setCodeParticipant(String.format("%03d", Integer.parseInt(fcra.getCodeParticipant())));
        }

        if (fcra.getNatureProp() != null) {
            fcra.setNatureProp(String.format("%-2s", fcra.getNatureProp()));
        }

        if (fcra.getNom() != null) {
            fcra.setNom(String.format("%-100s", fcra.getNom()));
        }

        if (fcra.getPrenom() != null) {
            fcra.setPrenom(String.format("%-100s", fcra.getPrenom()));
        }

        if (fcra.getNomArabe() != null) {
            fcra.setNomArabe(String.format("%-200s", fcra.getNomArabe()));
        }

        if (fcra.getCodeNaturePiece() != null) {
            switch (fcra.getCodeNaturePiece()) {
                case "CIN" -> fcra.setCodeNaturePiece("CI");
                case "Indéfini" -> fcra.setCodeNaturePiece("01");
                case "Carte de Séjour" -> fcra.setCodeNaturePiece("CS");
                case "Passeport" -> fcra.setCodeNaturePiece("PS");
                default -> fcra.setCodeNaturePiece("UI");
            }
        }

        if (fcra.getNumPiece() != null) {
            fcra.setNumPiece(String.format("%20s", fcra.getNumPiece()).replace(' ', '0'));
        }

        if (fcra.getCategorieInves() != null) {
            fcra.setCategorieInves(String.format("%-2s", fcra.getCategorieInves()));
        }

        if (fcra.getSecteur() != null) {
            fcra.setSecteur(String.format("%-2s", fcra.getSecteur()));
        }

        if (fcra.getNationalite() != null) {
            fcra.setNationalite(String.format("%-2s", fcra.getNationalite()));
        }

        if (fcra.getDateNaissance() == null) {
            fcra.setDateNaissance(LocalDate.of(1960,1,1));
        }

        if (fcra.getAdresse() != null) {
            fcra.setAdresse(String.format("%-100s", fcra.getAdresse()));
        }

        if (fcra.getVille() != null) {
            fcra.setVille(String.format("%-50s", fcra.getVille()));
        }

        if (fcra.getGouvernorat() != null) {
            fcra.setGouvernorat(String.format("%-50s", fcra.getGouvernorat()));
        }

        if (fcra.getCodePostal() != null) {
            fcra.setCodePostal(String.format("%-20s", fcra.getCodePostal()));
        }

        if (fcra.getTel() != null) {
            fcra.setTel(String.format("%-20s", fcra.getTel()));
        }

        if (fcra.getFax() != null) {
            fcra.setFax(String.format("%-20s", fcra.getFax()));
        }

        if (fcra.getEmail() != null) {
            fcra.setEmail(String.format("%-50s", fcra.getEmail()));
        }

        if (fcra.getCodeISIN() != null) {
            fcra.setCodeISIN(String.format("%-12s", fcra.getCodeISIN()));
        }

        if (fcra.getVote() != null) {
            fcra.setVote(String.format("%-10s", fcra.getVote()));
        }

        if (fcra.getDividend() != null) {
            fcra.setDividend(String.format("%-10s", fcra.getDividend()));
        }

        if (fcra.getRights() != null) {
            fcra.setRights(String.format("%-10s", fcra.getRights()));
        }

        if (fcra.getTypeCompte() != null) {
            fcra.setTypeCompte(String.format("%-1s", fcra.getTypeCompte()));
        }

        if (fcra.getSousCompte() != null) {
            fcra.setSousCompte(String.format("%-2s", fcra.getSousCompte()));
        }

        if (fcra.getCategorieAvoir() != null) {
            fcra.setCategorieAvoir(String.format("%03d", Integer.parseInt(fcra.getCategorieAvoir())));
        }

        if (fcra.getQuantite() != null) {
            fcra.setQuantite(String.format("%012d", Integer.parseInt(fcra.getQuantite())));
        }
    }

}
