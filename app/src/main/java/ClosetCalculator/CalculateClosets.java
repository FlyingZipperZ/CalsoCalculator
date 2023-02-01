package ClosetCalculator;

import ClosetCalculator.Calculations.*;
import ClosetCalculator.Panels.InputsLabelTxt;
import ExcelOut.ExcelOutput;

import javax.swing.table.DefaultTableModel;
import java.util.*;

public class CalculateClosets {
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
                        System.out.println("Did this run?");
                        System.out.println(rodsList.get(0));
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

        list.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        }.reversed());

        drawerList.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(7).compareTo(o2.get(7));
            }
        }.reversed());

        drawerList.sort(new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        }.reversed());

        System.out.println("*************** List: ******************");
        for(List<String> l1 : list) {
            System.out.println(Arrays.toString(l1.toArray()));
        }

        SortFunctions.sortReversed(1, drawerList);

        System.out.println("\n*************** Drawers List: ******************");
        for(List<String> dl1 : drawerList) {
            System.out.println(Arrays.toString(dl1.toArray()));
        }

        SortFunctions.sortReversed(7, rodsList);

        System.out.println("\n*************** Rods List: ******************");
        for(List<String> r : rodsList) {
            System.out.println(Arrays.toString(r.toArray()));
        }

        ExcelOutput.createExcel(list, drawerList, rodsList);

        System.out.println("\nList Run Successful");

//        System.out.println("Save File Location: " + SaveFile.createSavePopUp());

    }
}
