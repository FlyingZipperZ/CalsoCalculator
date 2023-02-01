package ExcelOut;

import ClosetCalculator.Calculations.FractionToDecimal;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Objects;

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

        for (int i = 0; i < list.size(); i++) {
            cells[i] = rows.createCell(i);
            if (i == 0 || i == 1 || i == 4) {

                cells[i].setCellValue(FractionToDecimal.convertFractionToDecimal(list.get(i)));
            } else if (!Objects.equals(list.get(i), null)) {
                cells[i].setCellValue(list.get(i));
            }
            cells[i].setCellStyle(rowStyle);
        }
    }

    public static void changeCellBackgroundColor(Cell cell) {
        CellStyle cellStyle = cell.getCellStyle();
        if(cellStyle == null) {
            cellStyle = cell.getSheet().getWorkbook().createCellStyle();
        }
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(cellStyle);
    }
    public static void setDrawersRows(XSSFWorkbook workbook, XSSFSheet sheet, int rowNumber, ArrayList<String> drawers) {
        // Create excel style
        XSSFCellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        cellStyle.setFillPattern(FillPatternType.FINE_DOTS);

        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        // Creates a font for the excel
        XSSFFont font = workbook.createFont();
        cellStyle.setFont(font);

        DataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("# ??/??"));

        // Creates cells to be filled
        XSSFCell[] cells = new XSSFCell[13];
        XSSFRow rows = sheet.createRow(rowNumber);

        for (int i = 0; i < drawers.size(); i++) {
            cells[i] = rows.createCell(i);

            if (drawers.get(i) != null) {
                if (i == 0 || i == 1 || i == 4 || i == 7) {
                    if (Objects.equals(drawers.get(i), "")) {
                        cells[i].setCellValue("");
                    } else {
                        cells[i].setCellValue(FractionToDecimal.convertFractionToDecimal(drawers.get(i)));
                    }
                } else if (!Objects.equals(drawers.get(i), null)) {
                    cells[i].setCellValue(drawers.get(i));
                }
            }
            cells[i].setCellStyle(cellStyle);
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
                cells[i].setCellValue(FractionToDecimal.convertFractionToDecimal(rods.get(i)));
            } else if (!Objects.equals(rods.get(i), null)) {
                cells[i].setCellStyle(null);
                cells[i].setCellValue(rods.get(i));
            }
            cells[i].setCellStyle(rowStyle);
        }
    }
}
