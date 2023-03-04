package ClosetCalculator.Calculations.DrawerUnits.FX;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.DrawerUnits.AddShelve.addShelves;
import static ClosetCalculator.Calculations.DrawerUnits.FX.DrawerFXBox.*;
import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class DrawerFX23 {
    public static ArrayList<ArrayList<String>> createFX23(Vector vector) {

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
                type, client, color, color));

        ArrayList<String> bottom = new ArrayList<>(List.of(
                String.valueOf(partMultiplier), "", "", "",
                sub(depthDrawer, "0.125"), "D","x", widthDrawer, "W",
                "Bottom",
                type, client, color, color));

        // Create upright arraylist
        ArrayList<String> upright = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "", "", "",
                depthDrawer, "D","x",
                "37 1/2", "H","Upright/WH",
                type, client, color, color));

        // Math when weird number
        String faceWidth = checkNumber(sub(widthDrawer, "0.5"));

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> drawerUnit = new ArrayList<>();

        drawerUnit.add(top);
        drawerUnit.addAll(calcFaceFX(partMultiplier, faceWidth, type, client, color));
        /**
         *  Drawer boxes
         */
        drawerUnit.addAll(calcBoxFX(partMultiplier, widthDrawer, type, client, color, depthDrawer));
        drawerUnit.add(upright);
        drawerUnit.add(bottom);
        drawerUnit.add(calcBottomFX(partMultiplier, depthDrawer, widthDrawer, type, client, color));


        if (!noShel.isEmpty()) {
            drawerUnit.add(addShelves(vector));
        }

        return drawerUnit;
    }
}
