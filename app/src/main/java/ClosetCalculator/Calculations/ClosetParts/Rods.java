package ClosetCalculator.Calculations.ClosetParts;

import ClosetCalculator.Calculations.DecimalToFraction;
import ClosetCalculator.Calculations.FractionToDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Components.JtextField.colorRodTxt;
import static ClosetCalculator.Components.JtextField.rodModTxt;

public class Rods {
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
                "r", rodsList.get(7), rodsList.get(8))));

        return newList;
    }
}
