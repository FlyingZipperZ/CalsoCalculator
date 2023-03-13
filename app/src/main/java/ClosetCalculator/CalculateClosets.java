package ClosetCalculator;

import ClosetCalculator.Calculations.ClosetParts.Shelves;

import javax.swing.table.DefaultTableModel;
import java.util.*;

import static ClosetCalculator.Calculations.ClosetParts.Bottoms.bottoms;
import static ClosetCalculator.Calculations.ClosetParts.Filler.createFiller;
import static ClosetCalculator.Calculations.ClosetParts.Rods.calcRods;
import static ClosetCalculator.Calculations.DrawerUnits.DS.D32Cab.createD32;
import static ClosetCalculator.Calculations.DrawerUnits.DS.DS32Drawer.createDS32;
import static ClosetCalculator.Calculations.DrawerUnits.FX.DrawerFX.createFX;
import static ClosetCalculator.Calculations.DrawerUnits.Kar.DrawerKar.createKar;
import static ClosetCalculator.Calculations.ClosetParts.Tops.tops;
import static ClosetCalculator.Calculations.ClosetParts.UpRight.calcUpRight;
import static ClosetCalculator.Calculations.DrawerUnits.Vas.DrawerVas.createVas;
import static ClosetCalculator.MasterArray.createMasterArray;
import static ClosetCalculator.SortFunctions.sortReversed;
import static ExcelOut.ExcelOutput.createExcel;

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
        ArrayList<ArrayList<String>> base = new ArrayList<>();
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
                case "d32":
                    drawerList.addAll(createD32(datum));
                    break;
                case "ds32":
                    drawerList.addAll(createDS32(datum));
                    break;
                case "fx23":
                case "fx24":
                    drawerList.addAll(createFX(datum));
                    break;
                case "kar23":
                case "kar24":
                    drawerList.addAll(createKar(datum));
                    break;
                case "vas23":
                case "vas24":
                    drawerList.addAll(createVas(datum));
                    break;
                case "f":
                    filler.add(createFiller(datum));
                    break;
                case "r":
                    rodsList.addAll(calcRods(datum));
                    break;
                case "b":
                    list.add(bottoms(datum));
                    break;
            }
        }

        ArrayList<ArrayList<ArrayList<String>>> unitColor = new ArrayList<>();
        ArrayList<ArrayList<String>> masterList = new ArrayList<>();
        masterList.addAll(0, list);
        masterList.addAll(list.size(), drawerList);
        masterList.addAll(list.size() + drawerList.size(), filler);

        masterList.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(13).compareTo(o2.get(13));
            }
        });

        if (!masterList.isEmpty()) {
            unitColor = createMasterArray(masterList);
        }

        if (!rodsList.isEmpty()) {
            // Sorts rods by width
            sortReversed(7, rodsList);
        }

        // Calls ExcelOutput to create the Excel file
        createExcel(unitColor, rodsList);

        System.out.println("\nList Run Successful");
    }
}
