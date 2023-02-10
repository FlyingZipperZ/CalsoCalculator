package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Tops {
    public static ArrayList<String> tops(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> tops = new ArrayList<>(vector.stream().toList());

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                tops.get(0),
                tops.get(3), "D","x", tops.get(1), "W", "",
                "", "", "",
                tops.get(4), tops.get(8), tops.get(9)));
    }
}
