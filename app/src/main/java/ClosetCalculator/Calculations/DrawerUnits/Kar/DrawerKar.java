package ClosetCalculator.Calculations.DrawerUnits.Kar;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.AddToString.add;
import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.DrawerUnits.Boxes.*;
import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class DrawerKar {
    public static ArrayList<ArrayList<String>> createKar(Vector vector) {

        /**
         * Input
         * 0 = numPieces stay 0
         * 1 = width make 4
         * 2 = Height make 4
         * 3 = Depth make 1
         * 4 = Type make 10
         * 8 = Client make 11
         * 9 = notes make 12
         * Top
         * Bottom
         * uprights * 2 generate auto 37 7/8
         * 5 faces
         * Drawer F&B * 10
         * Drawer Sides * 10
         * Drawer Bottoms * 5
         */

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> drawers = new ArrayList<>(vector.stream().toList());

        String numberParts = drawers.get(0);
        String widthDrawer = checkNumber(drawers.get(1));
//        String heightDrawer = checkNumber(drawers.get(2));
        String depthDrawer = checkNumber(drawers.get(3));
        String type = drawers.get(4);
//        String rod = drawers.get(5);
        String noShel = drawers.get(6);
        String client = drawers.get(7);
        String notes = drawers.get(8);
        String color = drawers.get(9);
//        String topOption = drawers.get(10);
//        String botOption = drawers.get(11);

        int partMultiplier = Integer.parseInt(numberParts);

        // Create top and bottom arraylist
        ArrayList<String> top = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                depthDrawer, "D","x", widthDrawer, "W", "",
                "", "", "Top",
                type, client, notes, color, color));

        ArrayList<String> bottom = new ArrayList<>(List.of(
                String.valueOf(partMultiplier), "", "", "",
                sub(depthDrawer, "0.125"), "D","x", widthDrawer, "W",
                "Bottom",
                type, client, notes, color, color));

        // Create upright arraylist
        ArrayList<String> upright = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "", "", "",
                depthDrawer, "D","x",
                "37 1/2", "H","Upright/WH",
                type, client, notes, color, color));

        String faceWidth = "";
        if (type.equals("kar23")) {
            // Math when weird number
            faceWidth = checkNumber(sub(widthDrawer, "0.5"));
        } else if (type.equals("kar24")) {
            faceWidth = checkNumber(add(widthDrawer, "0.5"));
        }

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> drawerUnit = new ArrayList<>();

        drawerUnit.add(top);

        drawerUnit.addAll(boxFaces(partMultiplier, faceWidth, type, client, notes, color));
        /**
         *  Drawer boxes
         */
        drawerUnit.addAll(boxBoxes(partMultiplier, widthDrawer, type, client, color, notes, depthDrawer));
        drawerUnit.add(upright);
        drawerUnit.add(bottom);
        drawerUnit.add(boxBottoms(partMultiplier, depthDrawer, widthDrawer, type, client, notes));

        if (!noShel.isEmpty()) {
            ArrayList<String> shelves = new ArrayList<>(List.of(
                    String.valueOf(noShel),
                    depthDrawer, "D", "x", widthDrawer, "W",
                    "", "", "",
                    "Shelves", type, client, "", color));
            drawerUnit.add(shelves);
        }

        return drawerUnit;
    }
}
