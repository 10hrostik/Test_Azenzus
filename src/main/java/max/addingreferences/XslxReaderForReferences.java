package max.addingreferences;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XslxReaderForReferences {

    private XSSFWorkbook workbook;
    private File file;
    private FileInputStream inputStream;
    private XSSFSheet sheet;
    private XSSFRow row;
    private FileOutputStream fileOut;
    private String path;

    public XslxReaderForReferences(String path) throws IOException {
        file = new File(path);
        inputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheetAt(0);
        this.path = path;
    }

    public int getCount() {
        return sheet.getLastRowNum()+1;
    }

    public String getDocumentId() {
        row = sheet.getRow(AddReferencesToMetaMain.position);
        int value = (int)row.getCell(0).getNumericCellValue();
        return Integer.toString(value);
    }

    public String[] getMetadataIds() {
        row = sheet.getRow(AddReferencesToMetaMain.position);
        String value;
        try {
            int v = (int)row.getCell(1).getNumericCellValue();
            value = Integer.toString(v);
        }
        catch(Exception e){
            value = row.getCell(1).toString();
        }
        String[] ids = value.split("[,\\;]");
        for (int i=0; i<ids.length; i++) {
            ids[i] = ids[i].replaceAll(" ", "");
        }
        return ids;
    }

    public void addColumns() {
        sheet.getRow(0).createCell(3).setCellValue("ID");
        sheet.getRow(0).createCell(4).setCellValue("Comment");
        sheet.getRow(0).createCell(5).setCellValue("Exception");
    }

    public void setID(int id) {
        row = sheet.getRow(AddReferencesToMetaMain.position);
        row.createCell(3).setCellValue(id);
    }

    public void setResult(String result) throws IOException {
        row = sheet.getRow(AddReferencesToMetaMain.position);
        row.createCell(4).setCellValue(result);
    }

    public void setException(String ex) {
        row = sheet.getRow(AddReferencesToMetaMain.position);
        try {
            String oldEx = row.getCell(5).getStringCellValue();
            row.createCell(5).setCellValue(oldEx+"  |  "+ex);
        }
        catch (Exception e) {
            row.createCell(5).setCellValue(ex);
        }
    }

    public void saveResult() throws IOException {
        addColumns();
        inputStream.close();
        path = path.replace(".xlsx", "-Result.xlsx");
        fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}