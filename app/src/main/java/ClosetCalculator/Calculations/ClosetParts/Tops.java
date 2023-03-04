package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;

public class Tops {
    public static ArrayList<String> tops(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> tops = new ArrayList<>(vector.stream().toList());

        String numberParts = tops.get(0);
        String widthDrawer = checkNumber(tops.get(1));
//        String heightDrawer = checkNumber(drawers.get(2));
        String depthDrawer = checkNumber(tops.get(3));
        String type = tops.get(4);
//        String rod = drawers.get(5);
//        String noShel = tops.get(6);
        String client = tops.get(7);
        String notes = tops.get(8);
        String color = tops.get(9);
//        String topOption = tops.get(10);
//        String botOption = tops.get(11);

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                numberParts,
                depthDrawer, "D","x", widthDrawer, "W", "",
                "", "", "",
                type, client, notes, color));
    }
}
