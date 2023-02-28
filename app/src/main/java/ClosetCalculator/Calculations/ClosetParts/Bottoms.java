package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class Bottoms {
    public static ArrayList<String> bottoms(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> bottoms = new ArrayList<>(vector.stream().toList());

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                bottoms.get(0),
                sub(bottoms.get(3), "0.125"), "D","x", bottoms.get(1), "W", "",
                "", "", "",
                "base", bottoms.get(7), bottoms.get(8)));
    }
}
