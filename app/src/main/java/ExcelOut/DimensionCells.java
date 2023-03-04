package ExcelOut;

import ClosetCalculator.Calculations.FractionToDecimal;
import org.apache.poi.ss.usermodel.*;
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

        // Creates a font for the excel
        XSSFFont font = workbook.createFont();
        rowStyle.setFont(font);

        rowStyle.setAlignment(HorizontalAlignment.CENTER);

        DataFormat format = workbook.createDataFormat();
        rowStyle.setDataFormat(format.getFormat("# ??/??"));

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
            if (!Objects.equals(list.get(1), "")) {
                if (i == 0 || i == 1 || i == 4) {
                    cells[i].setCellValue(convertFractionToDecimal(list.get(i)));
                } else if (!Objects.equals(list.get(i), null)) {
                    cells[i].setCellValue(list.get(i));
                }
            } else {
                if (i == 0 || i == 4 || i == 7) {
                    cells[i].setCellValue(convertFractionToDecimal(list.get(i)));
                } else if (!Objects.equals(list.get(i), null)) {
                    cells[i].setCellValue(list.get(i));
                }
            }
            cells[i].setCellStyle(rowStyle);
        }
    }

    public static void setDrawersRows(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, ArrayList<String> drawers) {
        // Create excel style
        XSSFCellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        // Creates a font for the excel
        XSSFFont font = workbook.createFont();
        cellStyle.setFont(font);

        DataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("# ??/??"));

        // Creates cells to be filled
        XSSFCell[] cells = new XSSFCell[13];
        XSSFRow rows = sheet.createRow(rowNumber);

        for (int i = 0; i < 13; i++) {
            cells[i] = rows.createCell(i);

            if (drawers.get(i) != null) {
                if (i == 0 || i == 1 || i == 4 || i == 7) {
                    if (Objects.equals(drawers.get(i), "")) {
                        cells[i].setCellValue("");
                    } else {
                        cells[i].setCellValue(convertFractionToDecimal(drawers.get(i)));
                    }
                } else if (!Objects.equals(drawers.get(i), null)) {
                    cells[i].setCellValue(drawers.get(i));
                }
            }
            cells[i].setCellStyle(cellStyle);
        }
        for (int i = 0; i < cells.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    public static void setRods(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, ArrayList<String> rods) {
        // Create excel style
        XSSFCellStyle rowStyle = workbook.createCellStyle();

        // Creates a font for the excel
        XSSFFont font = workbook.createFont();
        rowStyle.setFont(font);

        rowStyle.setAlignment(HorizontalAlignment.CENTER);

        DataFormat format = workbook.createDataFormat();
        rowStyle.setDataFormat(format.getFormat("# ??/??"));

        // Creates cells to be filled
        XSSFCell[] cells = new XSSFCell[13];
        XSSFRow rows = sheet.createRow(rowNumber);

        for (int i = 0; i < rods.size(); i++) {
            cells[i] = rows.createCell(i);
            if (i == 0 || i == 7) {
                cells[i].setCellStyle(rowStyle);
                cells[i].setCellValue(convertFractionToDecimal(rods.get(i)));
            } else if (!Objects.equals(rods.get(i), null)) {
                cells[i].setCellStyle(null);
                cells[i].setCellValue(rods.get(i));
            }
            cells[i].setCellStyle(rowStyle);
        }
    }
    public static void setFiller(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, ArrayList<String> filler) {
        // Create excel style
        XSSFCellStyle rowStyle = workbook.createCellStyle();

        // Creates a font for the excel
        XSSFFont font = workbook.createFont();
        rowStyle.setFont(font);

        rowStyle.setAlignment(HorizontalAlignment.CENTER);

        DataFormat format = workbook.createDataFormat();
        rowStyle.setDataFormat(format.getFormat("# ??/??"));

        // Creates cells to be filled
        XSSFCell[] cells = new XSSFCell[13];
        XSSFRow rows = sheet.createRow(rowNumber);

        for (int i = 0; i < filler.size(); i++) {
            cells[i] = rows.createCell(i);
            if (i == 0 || i == 1 || i == 4) {

                cells[i].setCellValue(convertFractionToDecimal(filler.get(i)));
            } else if (!Objects.equals(filler.get(i), null)) {
                cells[i].setCellValue(filler.get(i));
            }
            cells[i].setCellStyle(rowStyle);
        }
    }
}
