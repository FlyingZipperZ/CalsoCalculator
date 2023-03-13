package ExcelOut;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

public class ColorRow {

    // Gets color from colorTxt and puts it at the bottom of the file
    public static void createColorRow(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, String color) {
        // Create excel style
        XSSFCellStyle rowStyle = workbook.createCellStyle();

        // Creates a font for the excel
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14);
        rowStyle.setFont(font);

        DataFormat format = workbook.createDataFormat();
//        rowStyle.setDataFormat(format.getFormat("# ??/??"));

        rowStyle.setAlignment(HorizontalAlignment.CENTER);

        // Creates cells to be filled
        XSSFCell[] cells = new XSSFCell[13];
        XSSFRow rows = sheet.createRow(rowNumber);

        cells[1] = rows.createCell(1);
        cells[1].setCellStyle(rowStyle);
        cells[1].setCellValue(color);
    }
}
