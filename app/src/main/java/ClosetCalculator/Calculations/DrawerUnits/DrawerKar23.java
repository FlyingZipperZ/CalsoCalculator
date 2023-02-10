package ClosetCalculator.Calculations.DrawerUnits;

import ClosetCalculator.Calculations.SubtractFromString;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class DrawerKar23 {
    public static ArrayList<ArrayList<String>> createKar23(Vector vector) {

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
//        String noShel = drawers.get(6);
//        String selDep = drawers.get(7);
        String client = drawers.get(8);
        String notes = drawers.get(9);
        String color = drawers.get(10);
//        String topOption = drawers.get(11);
//        String botOption = drawers.get(12);

        int partMultiplier = Integer.parseInt(numberParts);

        // Create top and bottom arraylist
        ArrayList<String> top = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                depthDrawer, "D","x", widthDrawer, "W", "",
                "", "", "Top",
                type, client, notes));

        ArrayList<String> bottom = new ArrayList<>(List.of(
                String.valueOf(partMultiplier), "", "", "",
                depthDrawer, "D","x", widthDrawer, "W",
                "Bottom",
                type, client, notes));

        // Create upright arraylist
        ArrayList<String> upright = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "", "", "",
                depthDrawer, "D","x",
                "37 1/2", "H","Upright/WH",
                type, client, notes));

        // Math when weird number
        String faceWidth = sub(widthDrawer, "0.5");

        // Faces
        ArrayList<String> face = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                "6 1/4", "H","x", faceWidth, "W", "",
                "", "", "Face",
                type, client, notes));

        // Faces
        ArrayList<String> face23 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "7 1/5", "H","x", faceWidth, "W", "",
                "", "", "Face",
                type, client, notes));

        // Faces
        ArrayList<String> face45 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "8 3/4", "H","x", faceWidth, "W", "",
                "", "", "Face",
                type, client, notes));

        /**
         *  Drawer boxes
         */
        // Front and back
        ArrayList<String> frontAndBack1 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "5", "H","x", sub(widthDrawer, "4.0625"),
                "W", "", "", "", "Drawer Sides",
                type, client, notes));

        ArrayList<String> frontAndBack23 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "6 1/4", "H","x", sub(widthDrawer, "4.0625"),
                "W", "", "", "", "Drawer Sides",
                type, client, notes));

        ArrayList<String> frontAndBack45 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "7 1/2", "H","x", sub(widthDrawer, "4.0625"),
                "W", "", "", "", "Drawer Sides",
                type, client, notes));

        // Sides
        ArrayList<String> sides1 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "5", "H","x", SubtractFromString.subHalfInch(depthDrawer),
                "W", "", "", "", "Drawer F&B",
                type, client, notes));

        ArrayList<String> sides23 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "6 1/4", "H","x", SubtractFromString.subHalfInch(depthDrawer),
                "W", "", "", "", "Drawer F&B",
                type, client, notes));

        ArrayList<String> sides45 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "7 1/2", "H","x", SubtractFromString.subHalfInch(depthDrawer),
                "W", "", "", "", "Drawer F&B",
                type, client, notes));

        // Bottoms
        ArrayList<String> bottomDrawer = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 5),  "", "", "",
                SubtractFromString.subHalfInch(depthDrawer), "D","x",
                sub(widthDrawer, "2.5625"),
                "W", "Drawer Bottom (1/4')",
                type, client, notes));

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> drawerUnit = new ArrayList<>();

        drawerUnit.add(top);
        drawerUnit.add(bottom);
        drawerUnit.add(upright);
        drawerUnit.add(face);
        drawerUnit.add(face23);
        drawerUnit.add(face45);
        drawerUnit.add(frontAndBack1);
        drawerUnit.add(frontAndBack23);
        drawerUnit.add(frontAndBack45);
        drawerUnit.add(sides1);
        drawerUnit.add(sides23);
        drawerUnit.add(sides45);
        drawerUnit.add(bottomDrawer);

        return drawerUnit;
    }
}
