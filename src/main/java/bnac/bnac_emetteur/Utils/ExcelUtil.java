package bnac.bnac_emetteur.Utils;

import bnac.bnac_emetteur.DTO.FGO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {

    public static String HEADER[] = {
            "Num ligne", "Code BIC", "Code Participant", "Nature Proprietaire", "Nom", "Prenom",
            "Nom en arabe", "Code Nature piece d'identite", "Num piece d'identite", "Date de naissance",
            "Categorie de l'investisseur", "Secteur d'activite", "Nationalite", "Resident", "Adresse",
            "Ville", "Gouvernorat", "Code postal", "Num Tel", "Num Fax", "Email", "Ref Op", "Date Operation",
            "Date Comptable", "Code Op", "Sens Op", "Num transaction", "Code ISIN", "Vote", "Dividende",
            "Detenteurs de droits", "Type compte", "Sous compte", "Categorie d'avoirs", "Quantite",
            "Code BIC du Contrepartie", "Legacy code du contrepartie", "Pays de residence"
    };

    public static String SHEET_NAME = "FGO";

    public static ByteArrayInputStream dataToExcel(List<FGO> fgos) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {

        Sheet sheet = workbook.createSheet(SHEET_NAME);

        Row row = sheet.createRow(0);

        for (int i = 0; i < HEADER.length; i++)
        {
            Cell cell = row.createCell(i);
            cell.setCellValue(HEADER[i]);
        }

        int rowIndex = 1;
        for (FGO fgo : fgos)
        {
            Row row1 = sheet.createRow(rowIndex);

            row1.createCell(0).setCellValue(rowIndex);
            row1.createCell(1).setCellValue(fgo.getCodeBIC());
            row1.createCell(2).setCellValue(fgo.getCodeParticipant());
            row1.createCell(3).setCellValue(fgo.getNatureProp());
            row1.createCell(4).setCellValue(fgo.getNom());
            row1.createCell(5).setCellValue(fgo.getPrenom());
            row1.createCell(6).setCellValue(fgo.getNomArabe());
            row1.createCell(7).setCellValue(fgo.getCodeNaturePiece());
            row1.createCell(8).setCellValue(fgo.getNumPiece());
            row1.createCell(9).setCellValue(fgo.getDateNaissance());
            row1.createCell(10).setCellValue(fgo.getCategorieInves());
            row1.createCell(11).setCellValue(fgo.getSecteur());
            row1.createCell(12).setCellValue(fgo.getNationalite());
            row1.createCell(13).setCellValue(fgo.isResident());
            row1.createCell(14).setCellValue(fgo.getAdresse());
            row1.createCell(15).setCellValue(fgo.getVille());
            row1.createCell(16).setCellValue(fgo.getGouvernorat());
            row1.createCell(17).setCellValue(fgo.getCodePostal());
            row1.createCell(18).setCellValue(fgo.getTel());
            row1.createCell(19).setCellValue(fgo.getFax());
            row1.createCell(20).setCellValue(fgo.getEmail());
            row1.createCell(21).setCellValue(fgo.getRefOp());
            row1.createCell(22).setCellValue(fgo.getDateOp());
            row1.createCell(23).setCellValue(fgo.getDateComptable());
            row1.createCell(24).setCellValue(fgo.getCodeOp());
            row1.createCell(25).setCellValue(fgo.getSensOp());
            row1.createCell(26).setCellValue(fgo.getNumTransaction());
            row1.createCell(27).setCellValue(fgo.getCodeISIN());
            row1.createCell(28).setCellValue(fgo.getVote());
            row1.createCell(29).setCellValue(fgo.getDividende());
            row1.createCell(30).setCellValue(fgo.getDententeurs());
            row1.createCell(31).setCellValue(fgo.getTypeCompte());
            row1.createCell(32).setCellValue(fgo.getSousCompte());
            row1.createCell(33).setCellValue(fgo.getCategorieAvoir());
            row1.createCell(34).setCellValue(fgo.getQuantite());
            row1.createCell(35).setCellValue(fgo.getCodeBICContrepartie());
            row1.createCell(36).setCellValue(fgo.getLegacyCodeContrepartie());
            row1.createCell(37).setCellValue(fgo.getPays());

            rowIndex++;
        }

            workbook.write(byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally {
            workbook.close();
            byteArrayOutputStream.close();
        }
    }
}
