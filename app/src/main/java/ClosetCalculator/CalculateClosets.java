package ClosetCalculator;

import ClosetCalculator.Calculations.ClosetParts.Shelves;

import javax.swing.table.DefaultTableModel;
import java.util.*;

import static ClosetCalculator.Calculations.ClosetParts.Filler.createFiller;
import static ClosetCalculator.Calculations.ClosetParts.Rods.calcRods;
import static ClosetCalculator.Calculations.DrawerUnits.DrawerDS23.createDS23;
import static ClosetCalculator.Calculations.DrawerUnits.DrawerDS24.createDS24;
import static ClosetCalculator.Calculations.DrawerUnits.FX.DrawerFX23.createFX23;
import static ClosetCalculator.Calculations.DrawerUnits.FX.DrawerFX24.createFX24;
import static ClosetCalculator.Calculations.DrawerUnits.Kar.DrawerKar23.createKar23;
import static ClosetCalculator.Calculations.DrawerUnits.Kar.DrawerKar24.createKar24;
import static ClosetCalculator.Calculations.ClosetParts.Tops.tops;
import static ClosetCalculator.Calculations.ClosetParts.UpRight.calcUpRight;
import static ClosetCalculator.SortFunctions.sortReversed;

public class CalculateClosets {

    /**
     * Takes the default table model with all the data and checks the string value in the type section of the table
     * in order to run the correct calculation for use
     * @param dtm table from main panel
     */
    public static void calculate(DefaultTableModel dtm) {
        System.out.println("Closets Are being calculated\n");
        Vector<Vector> data = dtm.getDataVector();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<ArrayList<String>> drawerListds23 = new ArrayList<>();
        ArrayList<ArrayList<String>> drawerListds24 = new ArrayList<>();
        ArrayList<ArrayList<String>> drawerList = new ArrayList<>();
        ArrayList<ArrayList<String>> rodsList = new ArrayList<>();
        ArrayList<ArrayList<String>> filler = new ArrayList<>();

        for (Vector datum : data) {
            switch ((String) datum.get(4)) {
                case "u":
                    list.add(calcUpRight(datum));

                    break;
                case "s":
                    list.addAll(Shelves.calcShelves(datum));
                    if (!datum.get(5).equals("")) {
                        rodsList.addAll(calcRods(datum));
                    }
                    break;
                case "t":
                    list.add(tops(datum));
                    break;
                case "ds23":
                    drawerListds23.add(new ArrayList<String>(datum.stream().toList()));
                    break;
                case "ds24":
                    drawerListds24.add(new ArrayList<String>(datum.stream().toList()));
                    break;
                case "fx23":
                    drawerList.addAll(createFX23(datum));
                    break;
                case "fx24":
                    drawerList.addAll(createFX24(datum));
                    break;
                case "kar23":
                    drawerList.addAll(createKar23(datum));
                    break;
                case "kar24":
                    drawerList.addAll(createKar24(datum));
                    break;
                case "f":
                    filler.add(createFiller(datum));
                    break;
                case "r":
                    rodsList.addAll(calcRods(datum));
                    break;
            }
        }

        // Sorts list of parts by their width
        sortReversed(1, list);

        if (!drawerListds23.isEmpty()) {
            drawerList.addAll(createDS23(drawerListds23));
        } else {
            System.out.println("DS23 Not Populated");
        }

        if (!drawerListds24.isEmpty()) {
            drawerList.addAll(createDS24(drawerListds24));
        } else {
            System.out.println("DS24 Not Populated");
        }

        // Sorts drawerList by width
        sortReversed(1, drawerList);

        // Sorts drawerList by height
        sortReversed(7, rodsList);

        for (int i = 0; i < drawerList.size(); i++){
            System.out.println(drawerList.get(i));
        }

        // Calls ExcelOutput to create the Excel file
//        ExcelOutput.createExcel(list, drawerList, rodsList, filler);

        System.out.println("\nList Run Successful");
    }
}
