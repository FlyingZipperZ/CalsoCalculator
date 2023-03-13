package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;

public class UpRight {
    public static ArrayList<String> calcUpRight(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> uprights = new ArrayList<>(vector.stream().toList());

        String numberParts = uprights.get(0);
//        String widthDrawer = checkNumber(uprights.get(1));
        String heightDrawer = checkNumber(uprights.get(2));
        String depthDrawer = checkNumber(uprights.get(3));
        String type = uprights.get(4);
//        String rod = drawers.get(5);
//        String noShel = tops.get(6);
        String client = uprights.get(7);
        String notes = uprights.get(8);
        String color = uprights.get(9);
//        String topOption = tops.get(10);
//        String botOption = tops.get(11);

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                numberParts,
                depthDrawer, "D","x", heightDrawer, "W", "",
                "", "", "",
                type, client, notes, color, color));
    }
}
