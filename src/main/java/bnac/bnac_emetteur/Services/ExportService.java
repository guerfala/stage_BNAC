package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.DTO.FGO;
import bnac.bnac_emetteur.Repositories.OperationNRepo;
import bnac.bnac_emetteur.Utils.ExcelUtil;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExportService {

    @Autowired
    private OperationNRepo exportRepo;

    public ByteArrayInputStream getDataDownloaded(String emetteurId, String titreId, LocalDate minDate, LocalDate maxDate) throws IOException {
        List<FGO> fgos = exportRepo.getFGO(emetteurId, titreId, minDate, maxDate);
        ByteArrayInputStream data = ExcelUtil.dataToExcel(fgos);
        return data;
    }

    public ByteArrayInputStream getRegFileData(String emetteurId, String titreId, LocalDate minDate, LocalDate maxDate) throws IOException {
        List<FGO> fgos = exportRepo.getFGO(emetteurId, titreId, minDate, maxDate);
        String regFileContent = generateRegFileContent(fgos);
        return new ByteArrayInputStream(regFileContent.getBytes());
    }

    private String generateRegFileContent(List<FGO> fgos) {
        StringBuilder regContent = new StringBuilder();
        regContent.append("Num ligne;Code BIC;Code Participant;Nature Proprietaire;Nom;Prenom;"+
                "Nom en arabe;Code Nature piece d'identite;Num piece d'identite;Date de naissance;"+
                "Categorie de l'investisseur;Secteur d'activite;Nationalite;Resident;Adresse;"+
                "Ville;Gouvernorat;Code postal;Num Tel;Num Fax;Email;Ref Op;Date Operation;"+
                "Date Comptable;Code Op;Sens Op;Num transaction;Code ISIN;Vote;Dividende;"+
                "Detenteurs de droits;Type compte;Sous compte;Categorie d'avoirs;Quantite;"+
                "Code BIC du Contrepartie;Legacy code du contrepartie;Pays de residence;\n");

        int rowIndex = 1;

        for (FGO fgo : fgos) {
            regContent.append(rowIndex);
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
            regContent.append(fgo.isResident());
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
}
