package ExcelOut;

import org.apache.poi.ss.usermodel.CellReferenceType;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelOutput {
    public static void createExcel(ArrayList<ArrayList<String>> list, ArrayList<ArrayList<String>> drawers, ArrayList<ArrayList<String>> rods) {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("test");

        XSSFCellStyle plywood = workbook.createCellStyle();
        XSSFCellStyle restOfSheet = workbook.createCellStyle();

        // Create plywoodBold font
        XSSFFont plywoodBold = workbook.createFont();

        // Set up fonts for style
        plywoodBold.setBold(true);
        plywoodBold.setFontHeight(10);
        plywood.setFont(plywoodBold);
        
        XSSFFont cellFont = workbook.createFont();
        cellFont.setFontHeight(10);
        restOfSheet.setFont(cellFont);

        XSSFFont colorFont = workbook.createFont();
        colorFont.setBold(true);
        colorFont.setFontHeight(14);
        restOfSheet.setFont(colorFont);

        int rowNumber = 0;
        Header.setFirstRow(workbook, sheet, rowNumber++);
        rowNumber++;

        for (ArrayList<String> strings : list) {
            DimensionCells.setClosetRows(workbook, sheet, rowNumber++, strings);
        }
        for (ArrayList<String> drawer : drawers) {
            DimensionCells.setDrawersRows(workbook, sheet, rowNumber++, drawer);
        }

        rowNumber++;

        for (ArrayList<String> rod : rods) {
            DimensionCells.setRods(workbook, sheet, rowNumber++, rod);
        }

        rowNumber++;

        ColorRow.createRow(workbook, sheet, rowNumber);

        // Output file
        try {
            FileOutputStream out =  new FileOutputStream("Test.xlsx");
            workbook.write(out);
            out.close();
            System.out.println("Excel with formula cells written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
