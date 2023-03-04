package ClosetCalculator.Calculations.ClosetParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class Bottoms {
    public static ArrayList<String> bottoms(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> bottoms = new ArrayList<>(vector.stream().toList());

        String numberParts = bottoms.get(0);
        String widthDrawer = checkNumber(bottoms.get(1));
//        String heightDrawer = checkNumber(bottoms.get(2));
        String depthDrawer = checkNumber(bottoms.get(3));
        String type = bottoms.get(4);
//        String rod = drawers.get(5);
//        String noShel = bottoms.get(6);
        String client = bottoms.get(7);
        String notes = bottoms.get(8);
        String color = bottoms.get(9);
//        String topOption = filler.get(10);
//        String botOption = filler.get(11);

        // Create top and bottom arraylist
        return new ArrayList<>(List.of(
                numberParts,
                sub(depthDrawer, "0.125"), "D","x", widthDrawer, "W", "",
                "", "", "",
                "base", client, notes, color));
    }
}
