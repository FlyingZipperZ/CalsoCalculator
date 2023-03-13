package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.DecimalToFraction.convertDecimalToFraction;
import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimal;
import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimalRods;
import static ClosetCalculator.Components.JtextField.colorRodTxt;
import static ClosetCalculator.Components.JtextField.rodModTxt;

public class Rods {
    public static ArrayList<ArrayList<String>> calcRods(Vector vector) {
        // ArrayList that holds data for the shelves incoming
        ArrayList<String> rodsList = new ArrayList<>(vector.stream().toList());

        // ArrayList that adds all elements and gets pushed to the master list
        ArrayList<ArrayList<String>> newList = new ArrayList<>();

        double in = convertFractionToDecimal(rodsList.get(1)) -
                    convertFractionToDecimalRods(rodModTxt.getText());

        newList.add(new ArrayList<>(List.of(
                rodsList.get(5),
                colorRodTxt.getText().trim(), "", "", "",
                "", "", convertDecimalToFraction(in),"W", "",
                "r", rodsList.get(7), "")));

        return newList;
    }
}
