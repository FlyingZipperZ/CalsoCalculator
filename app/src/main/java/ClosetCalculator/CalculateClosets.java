package ClosetCalculator;

import ClosetCalculator.Calculations.*;
import ClosetCalculator.Frames.SaveFile;
import ClosetCalculator.Panels.InputsLabelTxt;
import ExcelOut.ExcelOutput;

import javax.swing.table.DefaultTableModel;
import java.util.*;

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
        ArrayList<ArrayList<String>> drawerList = new ArrayList<>();
        ArrayList<ArrayList<String>> rodsList = new ArrayList<>();

        for (Vector datum : data) {
            switch ((String) datum.get(4)) {
                case "u":
                    list.add(UpRight.calcUpRight(datum));
                    break;
                case "s":
                    list.addAll(Shelves.calcShelves(datum));
                    if (!datum.get(5).equals("")) {
                        rodsList.addAll(Shelves.calcRods(datum));
                    }
                    break;
                case "t":
                    list.add(Tops.calcUpRight(datum));
                    break;
                case "ds23":
                    drawerList.addAll(DrawerDS23.createDS23(datum));
                    break;
                case "ds24":
                    drawerList.addAll(DrawerDS24.createDS24(datum));
                    break;
                case "fx23":
                    drawerList.addAll(DrawerFX23.createFX23(datum));
                    break;
                case "fx24":
                    drawerList.addAll(DrawerFX24.createFX24(datum));
                    break;
                case "kar23":
                    drawerList.addAll(DrawerKar23.createKar23(datum));
                    break;
                case "kar24":
                    drawerList.addAll(DrawerKar24.createKar24(datum));
                    break;
            }
        }

        // Sorts list of parts by their width
        list.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        }.reversed());

        // Sorts drawerList by height
        drawerList.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(7).compareTo(o2.get(7));
            }
        }.reversed());

        // Sorts drawerList by width
        drawerList.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        }.reversed());

        // Sorts drawerList by width
        SortFunctions.sortReversed(1, drawerList);

        // Sorts drawerList by height
        SortFunctions.sortReversed(7, rodsList);

        // Calls ExcelOutput to create the Excel file
        ExcelOutput.createExcel(list, drawerList, rodsList);

        System.out.println("\nList Run Successful");
    }
}
