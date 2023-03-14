package ExcelOut;

import ClosetCalculator.Calculations.FractionToDecimal;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;

import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;

import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimal;

public class DimensionCells {
    public static void setClosetRows(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, ArrayList<String> list) {
        // Create excel style
        XSSFCellStyle rowStyle = workbook.createCellStyle();
        XSSFCellStyle notesStyle = workbook.createCellStyle();
        XSSFCellStyle numberColumn = workbook.createCellStyle();

        // Creates a font for the excel
        XSSFFont uprightFont = workbook.createFont();
        rowStyle.setFont(uprightFont);

        rowStyle.setAlignment(HorizontalAlignment.CENTER);
        notesStyle.setAlignment(HorizontalAlignment.LEFT);

        DataFormat format = workbook.createDataFormat();
        rowStyle.setDataFormat(format.getFormat("# ??/??"));
        numberColumn.setDataFormat(format.getFormat("##"));

        // Creates cells to be filled
        XSSFCell[] cells = new XSSFCell[13];
        XSSFRow rows = sheet.createRow(rowNumber);

        for (int i = 0; i < 13; i++) {
            cells[i] = rows.createCell (i);
            rowStyle.setFillForegroundColor(null);
            rowStyle.setFillPattern(FillPatternType.NO_FILL);
            if (Objects.equals(list.get(10), "fx23") || Objects.equals(list.get(10), "fx24") ||
                    Objects.equals(list.get(10), "kar23") || Objects.equals(list.get(10), "kar24") ||
                    Objects.equals(list.get(10), "vas23") || Objects.equals(list.get(10), "vas24") ||
                    Objects.equals(list.get(10), "d32") || Objects.equals(list.get(10), "ds32")) {
                rowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                rowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }

            if (Objects.equals(list.get(10), "u")) {
                uprightFont.setBold(true);
                rowStyle.setFont(uprightFont);
            }

            if (!Objects.equals(list.get(1), "")) {
                if (i == 1 || i == 4) {
                    cells[i].setCellValue(convertFractionToDecimal(list.get(i)));
                } else if (!Objects.equals(list.get(i), null)) {
                    cells[i].setCellValue(list.get(i));
                }
            } else {
                if (i == 4 || i == 7) {
                    cells[i].setCellValue(convertFractionToDecimal(list.get(i)));
                } else if (!Objects.equals(list.get(i), null)) {
                    cells[i].setCellValue(list.get(i));
                }
            }

            if (i == 12) {
                cells[i].setCellStyle(notesStyle);
            } else if (i == 0) {
                cells[i].setCellStyle(numberColumn);
                cells[i].setCellValue(Integer.parseInt(list.get(i)));
            } else {
                cells[i].setCellStyle(rowStyle);
            }
        }
    }

    public static void setRods(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, ArrayList<String> rods) {
        // Create excel style
        XSSFCellStyle rowStyle = workbook.createCellStyle();
        XSSFCellStyle notesStyle = workbook.createCellStyle();
        XSSFCellStyle numberColumn = workbook.createCellStyle();

        // Creates a font for the excel
        XSSFFont font = workbook.createFont();
        rowStyle.setFont(font);

        rowStyle.setAlignment(HorizontalAlignment.CENTER);
        notesStyle.setAlignment(HorizontalAlignment.LEFT);

        DataFormat format = workbook.createDataFormat();
        rowStyle.setDataFormat(format.getFormat("# ??/??"));

        // Creates cells to be filled
        XSSFCell[] cells = new XSSFCell[13];
        XSSFRow rows = sheet.createRow(rowNumber);

        for (int i = 0; i < 13; i++) {
            cells[i] = rows.createCell(i);
            if (i == 7) {
                cells[i].setCellStyle(rowStyle);
                cells[i].setCellValue(convertFractionToDecimal(rods.get(i)));
            } else if (!Objects.equals(rods.get(i), null)) {
                cells[i].setCellStyle(null);
                cells[i].setCellValue(rods.get(i));
            }
            if (i == 12) {
                cells[i].setCellStyle(notesStyle);
            } else if (i == 0) {
                cells[i].setCellStyle(numberColumn);
                cells[i].setCellValue(Integer.parseInt(rods.get(i)));
            } else {
                cells[i].setCellStyle(rowStyle);
            }
        }
    }
}
