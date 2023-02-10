package ClosetCalculator.Calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Components.JtextField.colorRodTxt;
import static ClosetCalculator.Components.JtextField.rodModTxt;
import static ClosetCalculator.Components.Radios.bottomYesRadio;
import static ClosetCalculator.Components.Radios.topYesRadio;

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
                SubtractFromString.subHalfInch(shelvesList.get(3)), "D", "x", shelvesList.get(1), "W", "",
                "", "", "",
                shelvesList.get(4), shelvesList.get(8), shelvesList.get(9))));

        if(topYesRadio.isSelected()) {
            // ArrayList that holds bottom data if needed
            ArrayList<String> bottomList = new ArrayList<>(List.of(
                    shelvesList.get(0),
                    shelvesList.get(3), "D","x", shelvesList.get(1), "W", "",
                    "", "", "",
                    "t", shelvesList.get(8), shelvesList.get(9)));
            newList.add(bottomList);
        }

        if(bottomYesRadio.isSelected()) {
            // ArrayList that holds bottom data if needed
            ArrayList<String> bottomList = new ArrayList<>(List.of(
                    shelvesList.get(0),
                    shelvesList.get(3), "D","x", shelvesList.get(1), "W", "",
                    "", "", "",
                    "bot", shelvesList.get(8), shelvesList.get(9)));
            newList.add(bottomList);
        }

        return newList;
    }

    public static ArrayList<ArrayList<String>> calcRods(Vector vector) {
        // ArrayList that holds data for the shelves incoming
        ArrayList<String> rodsList = new ArrayList<>(vector.stream().toList());

        // ArrayList that adds all elements and gets pushed to the master list
        ArrayList<ArrayList<String>> newList = new ArrayList<>();

        double in;

        if (rodModTxt.getText().isEmpty()) {
            in = FractionToDecimal.convertFractionToDecimal(rodsList.get(1)) -
                    FractionToDecimal.convertFractionToDecimalRods("3/16");
        } else {
            in = FractionToDecimal.convertFractionToDecimal(rodsList.get(1)) -
                    FractionToDecimal.convertFractionToDecimalRods(rodModTxt.getText());
        }

        newList.add(new ArrayList<>(List.of(
                rodsList.get(5),
                colorRodTxt.getText().trim(), "", "", "",
                "", "", DecimalToFraction.convertDecimalToFraction(in),"W", "",
                "r", rodsList.get(8), rodsList.get(9))));

        return newList;
    }
}
