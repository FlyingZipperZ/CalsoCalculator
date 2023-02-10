package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Filler {
    public static ArrayList<String> createFiller(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> filler = new ArrayList<>(vector.stream().toList());

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                filler.get(0),
                "", "", "",
                filler.get(1), "W","x", filler.get(2), "H", "",
                "Filler", filler.get(8), filler.get(9)));

    }
}
