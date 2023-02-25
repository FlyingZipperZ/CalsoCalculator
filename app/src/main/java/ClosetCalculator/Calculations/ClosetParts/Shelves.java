package ClosetCalculator.Calculations.ClosetParts;

import ClosetCalculator.Calculations.SubtractFromString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import static ClosetCalculator.Calculations.SubtractFromString.sub8thInch;

public class Shelves {
    /**
     * Inputs a vector line with the label "s"
     * takes off 1/8 depth on the shelves
     * and checks if there is a bottom on the unit
     * creates lists that manage the shelves and adds a bottom if selected
     * @param vector input
     * @return double ArrayList to be pushed to the master list in CalculateClosets.java
     */
    public static ArrayList<ArrayList<String>> calcShelves(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> shelvesList = new ArrayList<>(vector.stream().toList());

        // ArrayList that adds all elements and gets pushed to the master list
        ArrayList<ArrayList<String>> newList = new ArrayList<>();

        newList.add(new ArrayList<>(List.of(
                shelvesList.get(0),
                shelvesList.get(3), "D", "x",  sub8thInch(shelvesList.get(1)), "W", "",
                "", "", "",
                shelvesList.get(4), shelvesList.get(7), shelvesList.get(8))));

        if (Objects.equals(String.valueOf(shelvesList.get(10)), "true")) {
            // ArrayList that holds bottom data if needed
            ArrayList<String> bottomList = new ArrayList<>(List.of(
                    shelvesList.get(0),
                    shelvesList.get(3), "D","x", shelvesList.get(1), "W", "",
                    "", "", "",
                    "t", shelvesList.get(7), shelvesList.get(8)));
            newList.add(bottomList);
        }

        if (Objects.equals(String.valueOf(shelvesList.get(11)), "true")) {
            // ArrayList that holds bottom data if needed
            ArrayList<String> bottomList = new ArrayList<>(List.of(
                    shelvesList.get(0),
                    shelvesList.get(3), "D","x", shelvesList.get(1), "W", "",
                    "", "", "",
                    "bot", shelvesList.get(7), shelvesList.get(8)));
            newList.add(bottomList);
        }

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }

        return newList;
    }
}
