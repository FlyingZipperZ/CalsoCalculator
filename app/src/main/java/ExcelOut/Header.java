package ExcelOut;

import org.apache.poi.xssf.usermodel.*;

public class Header {
    public static void setFirstRow(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber) {
        // Create excel style
        XSSFCellStyle headerStyle = workbook.createCellStyle();

        // Creates a font for the excel
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14);
        headerStyle.setFont(font);

        // Creates cells to be filled
        XSSFCell[] cells = new XSSFCell[14];
        XSSFRow rows = sheet.createRow(rowNumber);

        // Cell A
        cells[0] = rows.createCell(0);
        cells[0].setCellValue("Number");

        // Cell B
        cells[1] = rows.createCell(1);
        cells[1].setCellValue("Dimensions");

        // Cell J
        cells[9] = rows.createCell(9);
        cells[9].setCellValue("Parts");

        // Cell K
        cells[10] = rows.createCell(10);
        cells[10].setCellValue("Type");

        // Cell L
        cells[11] = rows.createCell(11);
        cells[11].setCellValue("Client");

        // Cell M
        cells[12] = rows.createCell(12);
        cells[12].setCellValue("Notes");

    }
}
