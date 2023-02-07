package ClosetCalculator.Calculations;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DrawerDS23 {
    public static ArrayList<ArrayList<String>> createDS23(Vector vector) {

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

        int partMultiplier = Integer.parseInt(drawers.get(0));

        // Create top and bottom arraylist
        ArrayList<String> top = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                drawers.get(3), "D","x", drawers.get(1), "W", "",
                "", "", "Top",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        ArrayList<String> bottom = new ArrayList<>(List.of(
                String.valueOf(partMultiplier), "", "", "",
                drawers.get(3), "D","x", drawers.get(1), "W",
                "Bottom",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        // Create upright arraylist
        ArrayList<String> upright = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "", "", "",
                drawers.get(3), "D","x",
                SubtractFromString.sub(drawers.get(2), "1.5"), "H","Upright/WH",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        // Math when weird number
        String faceWidth = SubtractFromString.sub(drawers.get(1), "0.5");

        // Faces
        ArrayList<String> face = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                faceWidth, "H","x", drawers.get(2), "W", "",
                "", "", "Face",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        /**
         *  Drawer boxes
         */
        // Front and back
        ArrayList<String> frontAndBack1 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "5", "H","x", SubtractFromString.sub(drawers.get(1), "4.0625"),
                "W", "", "", "", "Drawer F&B",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        ArrayList<String> frontAndBack234 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 6),
                "6 1/4", "H","x", SubtractFromString.sub(drawers.get(1), "4.0625"),
                "W", "", "", "", "Drawer F&B",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        ArrayList<String> frontAndBack5 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "7 1/2", "H","x", SubtractFromString.sub(drawers.get(1), "4.0625"),
                "W", "", "", "", "Drawer F&B",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        // Sides
        ArrayList<String> sides12 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "5", "H","x", SubtractFromString.sub8th(drawers.get(3)),
                "W", "", "", "", "Drawer Sides",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        ArrayList<String> sides34 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 6),
                "6 1/4", "H","x", SubtractFromString.sub8th(drawers.get(3)),
                "W", "", "", "", "Drawer Sides",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        // ArrayList<String> sides5 = new ArrayList<>(List.of(
        //         String.valueOf(partMultiplier * 2),
        //         "7 1/2", "H","x", SubtractFromString.sub8th(drawers.get(3)),
        //         "W", "", "", "", "Drawer Sides",
        //         drawers.get(4), drawers.get(8), drawers.get(9)));

        // Bottoms
        ArrayList<String> bottomDrawer = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 5),  "", "", "",
                SubtractFromString.sub8th(drawers.get(3)), "D","x",
                SubtractFromString.sub(drawers.get(1), "2.5625"),
                "W", "Drawer Bottom (1/4')",
                drawers.get(4), drawers.get(8), drawers.get(9)));

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> drawerUnit = new ArrayList<>();

        drawerUnit.add(top);
        drawerUnit.add(bottom);
        drawerUnit.add(upright);
        drawerUnit.add(face);
        drawerUnit.add(frontAndBack1);
        drawerUnit.add(frontAndBack234);
        drawerUnit.add(frontAndBack5);
        drawerUnit.add(sides12);
        drawerUnit.add(sides34);
        // drawerUnit.add(sides5);
        drawerUnit.add(bottomDrawer);

        return drawerUnit;
    }
}
