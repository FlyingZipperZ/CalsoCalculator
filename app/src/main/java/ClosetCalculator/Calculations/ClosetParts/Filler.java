package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;

public class Filler {
    public static ArrayList<String> createFiller(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> filler = new ArrayList<>(vector.stream().toList());

        String numberParts = filler.get(0);
        String widthDrawer = checkNumber(filler.get(1));
        String heightDrawer = checkNumber(filler.get(2));
//        String depthDrawer = checkNumber(filler.get(3));
        String type = filler.get(4);
//        String rod = drawers.get(5);
        String noShel = filler.get(6);
        String client = filler.get(7);
        String notes = filler.get(8);
        String color = filler.get(9);
//        String topOption = filler.get(10);
//        String botOption = filler.get(11);

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                numberParts,
                "", "", "",
                widthDrawer, "W","x", heightDrawer, "H", "",
                "Filler", client, notes, color));

    }
}
