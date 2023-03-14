package ExcelOut;

import ClosetCalculator.Frames.SaveFile;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static ClosetCalculator.SortFunctions.sortReversed;
import static ClosetCalculator.SortFunctions.sortReversed2d;
import static ExcelOut.ColorRow.createColorRow;
import static ExcelOut.DimensionCells.setClosetRows;
import static ExcelOut.DimensionCells.setRods;
import static ExcelOut.Header.setFirstRow;

public class ExcelOutput {
    /**
     * Calls of this will export an Excel file which has different colors and all the parts
     * @param unitColor 3d Array that contains all the colors and all the parts for the list
     * @param rods list of rods
     */
    public static void createExcel(ArrayList<ArrayList<ArrayList<String>>> unitColor, ArrayList<ArrayList<String>> rods) {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet();

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

        // Header only
        int rowNumber = 0;
        setFirstRow(workbook, sheet, rowNumber++);
        rowNumber++;

        // pulls info from the 3d array and puts them in the list
        for (int arrayX = 0; arrayX < unitColor.size()-1; arrayX++) {
            sortReversed2d(unitColor.get(arrayX));
            for (int arrayY = 0; arrayY < unitColor.get(arrayX).size(); arrayY++) {
                setClosetRows(workbook, sheet, rowNumber++, unitColor.get(arrayX).get(arrayY));
            }
            rowNumber++;
            String color = unitColor.get(arrayX).get(0).get(13);
            createColorRow(workbook, sheet, rowNumber++, color);
            rowNumber++;
        }

        rowNumber++;

        for (ArrayList<String> rod : rods) {
            setRods(workbook, sheet, rowNumber++, rod);
        }

        for (int i = 0; i < 13; i++) {
            sheet.autoSizeColumn(i);
        }

        sheet.setPrintGridlines(true);

        String location = SaveFile.createSavePopUp();

        System.out.println("location: " + location + ".xlsx");

        if (!location.equals("")) {
            // Output file
            try {
                FileOutputStream out = new FileOutputStream(location + ".xlsx");
                workbook.write(out);
                out.close();
                System.out.println("Excel with formula cells written successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
