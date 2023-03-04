package ClosetCalculator.Calculations.ClosetParts;

import ClosetCalculator.Calculations.SubtractFromString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
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

        String numberParts = shelvesList.get(0);
        String widthDrawer = checkNumber(shelvesList.get(1));
//        String heightDrawer = checkNumber(drawers.get(2));
        String depthDrawer = checkNumber(shelvesList.get(3));
        String type = shelvesList.get(4);
//        String rod = drawers.get(5);
//        String noShel = shelvesList.get(6);
        String client = shelvesList.get(7);
        String notes = shelvesList.get(8);
        String color = shelvesList.get(9);
        boolean topOption = (boolean) vector.get(10);
        boolean botOption = (boolean) vector.get(11);

        newList.add(new ArrayList<>(List.of(
                numberParts,
                sub8thInch(depthDrawer), "D", "x",  widthDrawer, "W", "",
                "", "", "",
                type, client, notes, color)));

        if (Objects.equals(topOption, true)) {
            // ArrayList that holds top data if needed
            ArrayList<String> bottomList = new ArrayList<>(List.of(
                    "1",
                    depthDrawer, "D","x", widthDrawer, "W", "",
                    "", "", "",
                    "t", client, "1 euro", color));
            newList.add(bottomList);
        }

        if (Objects.equals(botOption, true)) {
            // ArrayList that holds bottom data if needed
            ArrayList<String> bottomList = new ArrayList<>(List.of(
                    "1",
                    depthDrawer, "D","x", widthDrawer, "W", "",
                    "", "", "",
                    "bot", client, "", color));
            newList.add(bottomList);
        }

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }

        return newList;
    }
}
