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
        fgo.setNumLigne(fgo.getNumLigne() != null ? String.format("%05d", Integer.parseInt(fgo.getNumLigne())) : String.format("%5s", " "));

        fgo.setCodeBIC(fgo.getCodeBIC() != null ? String.format("%-11s", fgo.getCodeBIC()) : String.format("%-11s", " "));

        fgo.setCodeParticipant(fgo.getCodeParticipant() != null ? String.format("%03d", Integer.parseInt(fgo.getCodeParticipant())) : String.format("%3s", " "));

        fgo.setNatureProp(fgo.getNatureProp() != null ? String.format("%-2s", fgo.getNatureProp()) : String.format("%-2s", " "));

        fgo.setNom(fgo.getNom() != null ? String.format("%-100s", fgo.getNom()) : String.format("%-100s", " "));

        fgo.setPrenom(fgo.getPrenom() != null ? String.format("%-100s", fgo.getPrenom()) : String.format("%-100s", " "));

        fgo.setNomArabe(fgo.getNomArabe() != null ? String.format("%-200s", fgo.getNomArabe()) : String.format("%-200s", " "));

        if (fgo.getCodeNaturePiece() != null) {
            switch (fgo.getCodeNaturePiece()) {
                case "CIN" -> fgo.setCodeNaturePiece("CI");
                case "Indéfini" -> fgo.setCodeNaturePiece("01");
                case "Carte de Séjour" -> fgo.setCodeNaturePiece("CS");
                case "Passeport" -> fgo.setCodeNaturePiece("PS");
                default -> fgo.setCodeNaturePiece("UI");
            }
        } else {
            fgo.setCodeNaturePiece("  ");
        }

        fgo.setNumPiece(fgo.getNumPiece() != null ? String.format("%020d", Long.parseLong(fgo.getNumPiece())) : String.format("%20s", " "));

        fgo.setCategorieInves(fgo.getCategorieInves() != null ? String.format("%-2s", fgo.getCategorieInves()) : String.format("%-2s", " "));

        fgo.setSecteur(fgo.getSecteur() != null ? String.format("%-2s", fgo.getSecteur()) : String.format("%-2s", " "));

        fgo.setNationalite(fgo.getNationalite() != null ? String.format("%-2s", fgo.getNationalite()) : String.format("%-2s", " "));

        if (fgo.getDateNaissance() == null) {
            fgo.setDateNaissance(LocalDate.of(1960, 1, 1));
        }

        fgo.setAdresse(fgo.getAdresse() != null ? String.format("%-100s", fgo.getAdresse()) : String.format("%-100s", " "));

        fgo.setVille(fgo.getVille() != null ? String.format("%-50s", fgo.getVille()) : String.format("%-50s", " "));

        fgo.setGouvernorat(fgo.getGouvernorat() != null ? String.format("%-50s", fgo.getGouvernorat()) : String.format("%-50s", " "));

        fgo.setCodePostal(fgo.getCodePostal() != null ? String.format("%-20s", fgo.getCodePostal()) : String.format("%-20s", " "));

        fgo.setTel(fgo.getTel() != null ? String.format("%-20s", fgo.getTel()) : String.format("%-20s", " "));

        fgo.setFax(fgo.getFax() != null ? String.format("%-20s", fgo.getFax()) : String.format("%-20s", " "));

        fgo.setEmail(fgo.getEmail() != null ? String.format("%-50s", fgo.getEmail()) : String.format("%-50s", " "));

        fgo.setRefOp(fgo.getRefOp() != null ? String.format("%07d", Integer.parseInt(fgo.getRefOp())) : String.format("%7s", " "));

        fgo.setCodeOp(fgo.getCodeOp() != null ? String.format("%-2s", fgo.getCodeOp()) : String.format("%-2s", " "));

        fgo.setSensOp(fgo.getSensOp() != null ? String.format("%-1s", fgo.getSensOp()) : String.format("%-1s", " "));

        fgo.setNumTransaction(fgo.getNumTransaction() != null ? String.format("%-10s", fgo.getNumTransaction()) : String.format("%-10s", " "));

        fgo.setCodeISIN(fgo.getCodeISIN() != null ? String.format("%-12s", fgo.getCodeISIN()) : String.format("%-12s", " "));

        fgo.setVote(fgo.getVote() != null ? String.format("%-10s", fgo.getVote()) : String.format("%-10s", " "));

        fgo.setDividende(fgo.getDividende() != null ? String.format("%-10s", fgo.getDividende()) : String.format("%-10s", " "));

        fgo.setDententeurs(fgo.getDententeurs() != null ? String.format("%-10s", fgo.getDententeurs()) : String.format("%-10s", " "));

        fgo.setTypeCompte(fgo.getTypeCompte() != null ? String.format("%-1s", fgo.getTypeCompte()) : String.format("%-1s", " "));

        fgo.setSousCompte(fgo.getSousCompte() != null ? String.format("%-2s", fgo.getSousCompte()) : String.format("%-2s", " "));

        fgo.setCategorieAvoir(fgo.getCategorieAvoir() != null ? String.format("%03d", Integer.parseInt(fgo.getCategorieAvoir())) : String.format("%3s", " "));

        fgo.setQuantite(fgo.getQuantite() != null ? String.format("%012d", Integer.parseInt(fgo.getQuantite())) : String.format("%12s", " "));

        fgo.setCodeBICContrepartie(fgo.getCodeBICContrepartie() != null ? String.format("%-11s", fgo.getCodeBICContrepartie()) : String.format("%-11s", " "));

        fgo.setLegacyCodeContrepartie(fgo.getLegacyCodeContrepartie() != null ? String.format("%-3s", fgo.getLegacyCodeContrepartie()) : String.format("%-3s", " "));

        fgo.setPays(fgo.getPays() != null ? String.format("%-2s", fgo.getPays()) : String.format("%-2s", " "));
    }

    public void applyRestrictionsFCRA(FCRA fcra) {

        fcra.setNumLigne(fcra.getNumLigne() != null ? String.format("%05d", Integer.parseInt(fcra.getNumLigne())) : "     ");
        fcra.setCodeBIC(fcra.getCodeBIC() != null ? String.format("%-11s", fcra.getCodeBIC()) : "           ");
        fcra.setCodeParticipant(fcra.getCodeParticipant() != null ? String.format("%03d", Integer.parseInt(fcra.getCodeParticipant())) : "   ");
        fcra.setNatureProp(fcra.getNatureProp() != null ? String.format("%-2s", fcra.getNatureProp()) : "  ");
        fcra.setNom(fcra.getNom() != null ? String.format("%-100s", fcra.getNom()) : " ".repeat(100));
        fcra.setPrenom(fcra.getPrenom() != null ? String.format("%-100s", fcra.getPrenom()) : " ".repeat(100));
        fcra.setNomArabe(fcra.getNomArabe() != null ? String.format("%-200s", fcra.getNomArabe()) : " ".repeat(200));

        if (fcra.getCodeNaturePiece() != null) {
            switch (fcra.getCodeNaturePiece()) {
                case "CIN" -> fcra.setCodeNaturePiece("CI");
                case "Indéfini" -> fcra.setCodeNaturePiece("01");
                case "Carte de Séjour" -> fcra.setCodeNaturePiece("CS");
                case "Passeport" -> fcra.setCodeNaturePiece("PS");
                default -> fcra.setCodeNaturePiece("UI");
            }
        } else {
            fcra.setCodeNaturePiece("  ");
        }

        fcra.setNumPiece(fcra.getNumPiece() != null ? String.format("%20s", fcra.getNumPiece()).replace(' ', '0') : "00000000000000000000");
        fcra.setCategorieInves(fcra.getCategorieInves() != null ? String.format("%-2s", fcra.getCategorieInves()) : "  ");
        fcra.setSecteur(fcra.getSecteur() != null ? String.format("%-2s", fcra.getSecteur()) : "  ");
        fcra.setNationalite(fcra.getNationalite() != null ? String.format("%-2s", fcra.getNationalite()) : "  ");
        fcra.setDateNaissance(fcra.getDateNaissance() != null ? fcra.getDateNaissance() : LocalDate.of(1960, 1, 1));
        fcra.setAdresse(fcra.getAdresse() != null ? String.format("%-100s", fcra.getAdresse()) : " ".repeat(100));
        fcra.setVille(fcra.getVille() != null ? String.format("%-50s", fcra.getVille()) : " ".repeat(50));
        fcra.setGouvernorat(fcra.getGouvernorat() != null ? String.format("%-50s", fcra.getGouvernorat()) : " ".repeat(50));
        fcra.setCodePostal(fcra.getCodePostal() != null ? String.format("%-20s", fcra.getCodePostal()) : " ".repeat(20));
        fcra.setTel(fcra.getTel() != null ? String.format("%-20s", fcra.getTel()) : " ".repeat(20));
        fcra.setFax(fcra.getFax() != null ? String.format("%-20s", fcra.getFax()) : " ".repeat(20));
        fcra.setEmail(fcra.getEmail() != null ? String.format("%-50s", fcra.getEmail()) : " ".repeat(50));
        fcra.setCodeISIN(fcra.getCodeISIN() != null ? String.format("%-12s", fcra.getCodeISIN()) : " ".repeat(12));
        fcra.setVote(fcra.getVote() != null ? String.format("%-10s", fcra.getVote()) : " ".repeat(10));
        fcra.setDividend(fcra.getDividend() != null ? String.format("%-10s", fcra.getDividend()) : " ".repeat(10));
        fcra.setRights(fcra.getRights() != null ? String.format("%-10s", fcra.getRights()) : " ".repeat(10));
        fcra.setTypeCompte(fcra.getTypeCompte() != null ? String.format("%-1s", fcra.getTypeCompte()) : " ");
        fcra.setSousCompte(fcra.getSousCompte() != null ? String.format("%-2s", fcra.getSousCompte()) : "  ");
        fcra.setCategorieAvoir(fcra.getCategorieAvoir() != null ? String.format("%03d", Integer.parseInt(fcra.getCategorieAvoir())) : "000");
        fcra.setQuantite(fcra.getQuantite() != null ? String.format("%012d", Integer.parseInt(fcra.getQuantite())) : "000000000000");
    }

}
