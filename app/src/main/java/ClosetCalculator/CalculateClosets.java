package ClosetCalculator;

import ClosetCalculator.Calculations.ClosetParts.Shelves;
import ExcelOut.ExcelOutput;

import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Array;
import java.util.*;

import static ClosetCalculator.Calculations.ClosetParts.Bottoms.bottoms;
import static ClosetCalculator.Calculations.ClosetParts.Filler.createFiller;
import static ClosetCalculator.Calculations.ClosetParts.Rods.calcRods;
import static ClosetCalculator.Calculations.DrawerUnits.DS.D32Cab.createD32;
import static ClosetCalculator.Calculations.DrawerUnits.DS.DS32Drawer.createDS32;
import static ClosetCalculator.Calculations.DrawerUnits.FX.DrawerFX23.createFX23;
import static ClosetCalculator.Calculations.DrawerUnits.FX.DrawerFX24.createFX24;
import static ClosetCalculator.Calculations.DrawerUnits.Kar.DrawerKar23.createKar23;
import static ClosetCalculator.Calculations.DrawerUnits.Kar.DrawerKar24.createKar24;
import static ClosetCalculator.Calculations.ClosetParts.Tops.tops;
import static ClosetCalculator.Calculations.ClosetParts.UpRight.calcUpRight;
import static ClosetCalculator.Calculations.DrawerUnits.Vas.Vas23.createVas23;
import static ClosetCalculator.Calculations.DrawerUnits.Vas.Vas24.createVas24;
import static ClosetCalculator.ColorMatch.getNumberOfColors;
import static ClosetCalculator.SortFunctions.sortReversed;
import static ClosetCalculator.SortFunctions.sortReversed2d;

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
        ArrayList<ArrayList<String>> drawerListD32 = new ArrayList<>();
        ArrayList<ArrayList<String>> drawerListDS32 = new ArrayList<>();
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
                case "vas23":
                    drawerList.addAll(createVas23(datum));
                    break;
                case "vas24":
                    drawerList.addAll(createVas24(datum));
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

        int colorNum = getNumberOfColors(masterList);

        int arrayY = 0;
        String color = masterList.get(0).get(13);
        int masterListY = 0;

        unitColor.add(new ArrayList<ArrayList<String>>());
        // Add different units to different axis
        for (int arrayX = 0; arrayX < colorNum; arrayX++) {
//            System.out.println("*************************** Color: " + color + " ***************************");
            if (masterList.size() > arrayX+1) {
                if (!Objects.equals(masterList.get(arrayX).get(1), masterList.get(arrayX + 1).get(1))) {
                    arrayY = 0;
                    unitColor.add(new ArrayList<ArrayList<String>>()); // runs as many times as the colorNum allows
                }
            }
            while (Objects.equals(color, masterList.get(masterListY).get(13))) {
                unitColor.get(arrayX).add(new ArrayList<>());
                unitColor.get(arrayX).set(arrayY, masterList.get(masterListY));
                if (masterListY < masterList.size()-1) {
                    masterListY++;
                    arrayY++;
                } else {
                    break;
                }
            }
            color = masterList.get(masterListY).get(13);
        }

        // Sorts rods by width
        sortReversed(7, rodsList);

        // Calls ExcelOutput to create the Excel file
        ExcelOutput.createExcel(unitColor, rodsList);

        System.out.println("\nList Run Successful");
    }
}
