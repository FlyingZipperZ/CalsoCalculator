package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class Bottoms {
    public static ArrayList<String> bottoms(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> tops = new ArrayList<>(vector.stream().toList());

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                tops.get(0),
                sub(tops.get(3), "0.125"), "D","x", tops.get(1), "W", "",
                "", "", "",
                tops.get(4), tops.get(7), tops.get(8)));
    }
}
