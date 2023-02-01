package ClosetCalculator.Calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UpRight {
    public static ArrayList<String> calcUpRight(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> uprights = new ArrayList<>(vector.stream().toList());

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                uprights.get(0),
                uprights.get(3), "D","x", uprights.get(2), "W", "",
                "", "", "",
                uprights.get(4), uprights.get(8), uprights.get(9)));
    }
}
