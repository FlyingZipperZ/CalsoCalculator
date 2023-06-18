package ClosetCalculator.Calculations.DrawerUnits;

import java.util.ArrayList;
import java.util.List;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimal;
import static ClosetCalculator.Calculations.SubtractFromString.sub;
import static ClosetCalculator.Calculations.SubtractFromString.sub8thInch;
import static ClosetCalculator.SortFunctions.sortReversed;

public class Boxes {
    // Box Face
    public static ArrayList<ArrayList<String>> boxFaces(int partMultiplier, String faceWidth, String type,
                                                           String client, String notes, String color) {

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> faces = new ArrayList<>();

        switch (type) {
            case "vas23", "vas24": {
                // Faces
                ArrayList<String> face123 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 3),
                        "7 1/2", "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        type, client, notes, color));

                // Faces
                ArrayList<String> face45 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "8 3/4", "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        type, client, notes, color));

                faces.add(face123);
                faces.add(face45);
            }
            case "kar23", "kar24": {
                // Faces
                ArrayList<String> face = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier),
                        "6 1/4", "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        type, client, notes, color));

                // Faces
                ArrayList<String> face23 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "7 1/2", "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        type, client, notes, color));

                // Faces
                ArrayList<String> face45 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "8 3/4", "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        type, client, notes, color));

                faces.add(face);
                faces.add(face23);
                faces.add(face45);
            }
            case "fx23", "fx24": {
                // Faces
                ArrayList<String> face = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier),
                        "6 1/4", "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        type, client, color, color));

                // Faces
                ArrayList<String> face234 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 3),
                        "7 1/2", "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        type, client, color, color));

                // Faces
                ArrayList<String> face5 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier),
                        "8 3/4", "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        type, client, color, color));
                faces.add(face);
                faces.add(face234);
                faces.add(face5);

                sortReversed(1, faces);
            }
        }

        return faces;
    }

    public static ArrayList<ArrayList<String>> boxBoxes(int partMultiplier, String widthDrawer, String type,
                                                          String client, String color, String notes, String depthDrawer) {

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> box = new ArrayList<>();

        double depth = convertFractionToDecimal(depthDrawer);

        if (depth >= 11.75 && depth <= 13.625) {
            depthDrawer = String.valueOf(11.75);
        }
        if (depth >= 13.75 && depth <= 15.625) {
            depthDrawer = String.valueOf(13.75);
        }
        if (depth >= 15.75 && depth <= 17.625) {
            depthDrawer = String.valueOf(15.75);
        }
        if (depth >= 17.75 && depth <= 19.625) {
            depthDrawer = String.valueOf(17.75);
        }
        if (depth >= 19.75 && depth <= 21.625) {
            depthDrawer = String.valueOf(19.75);
        }
        if (depth >= 21.75 && depth <= 23.625) {
            depthDrawer = String.valueOf(21.75);
        }
        if (depth >= 23.75 && depth <= 25.625) {
            depthDrawer = String.valueOf(23.75);
        }

        /**
         *  Drawer boxes
         */
        switch (type) {
            case "vas23", "vas24": {
                String boxWidth = checkNumber(sub(widthDrawer, "4.0625"));
                // Front and back
                ArrayList<String> frontAndBack123 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 6),
                        "6 1/4", "H", "x", boxWidth,
                        "W", "", "", "", "",
                        type, client, notes, "White"));

                ArrayList<String> frontAndBack45 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 4),
                        "7 1/2", "H", "x", boxWidth,
                        "W", "", "", "", "Drawer F&B",
                        type, client, notes, "White"));

                // Sides
                String boxDepth = checkNumber(depthDrawer);

                ArrayList<String> sides123 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 6),
                        "6 1/4", "H", "x", boxDepth,
                        "W", "", "", "", "Drawer Sides",
                        type, client, notes, "White"));

                ArrayList<String> sides45 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 4),
                        "7 1/2", "H", "x", boxDepth,
                        "W", "", "", "", "Drawer Sides",
                        type, client, notes, "White"));

                box.add(frontAndBack123);
                box.add(frontAndBack45);
                box.add(sides123);
                box.add(sides45);
            }
            case "kar23", "kar24": {
                String boxWidth = checkNumber(sub(widthDrawer, "4.0625"));
                // Front and back
                ArrayList<String> frontAndBack1 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "5", "H","x", boxWidth,
                        "W", "", "", "", "Drawer F&B",
                        type, client, notes, "White"));

                ArrayList<String> frontAndBack234 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 4),
                        "6 1/4", "H","x", boxWidth,
                        "W", "", "", "", "Drawer F&B",
                        type, client, notes, "White"));

                ArrayList<String> frontAndBack5 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 4),
                        "7 1/2", "H","x", boxWidth,
                        "W", "", "", "", "Drawer F&B",
                        type, client, notes, "White"));

                // Sides
                String boxDepth = checkNumber(depthDrawer);

                ArrayList<String> sides1 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "5", "H","x", boxDepth,
                        "W", "", "", "", "Drawer Sides",
                        type, client, notes, "White"));

                ArrayList<String> sides234 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 4),
                        "6 1/4", "H","x", boxDepth,
                        "W", "", "", "", "Drawer Sides",
                        type, client, notes, "White"));

                ArrayList<String> sides5 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 4),
                        "7 1/2", "H","x", boxDepth,
                        "W", "", "", "", "Drawer Sides",
                        type, client, notes, "White"));

                box.add(frontAndBack1);
                box.add(frontAndBack234);
                box.add(frontAndBack5);
                box.add(sides1);
                box.add(sides234);
                box.add(sides5);

            }
            case "fx23", "fx24": {
                String boxWidth = checkNumber(sub(widthDrawer, "4.0625"));
                // Front and back
                ArrayList<String> frontAndBack1 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "5", "H", "x", boxWidth,
                        "W", "", "", "", "Drawer F&B",
                        type, client, "White", color));

                ArrayList<String> frontAndBack234 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 6),
                        "6 1/4", "H", "x", boxWidth,
                        "W", "", "", "", "Drawer F&B",
                        type, client, "White", color));

                ArrayList<String> frontAndBack5 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "7 1/2", "H", "x", boxWidth,
                        "W", "", "", "", "Drawer F&B",
                        type, client, "White", color));

                // Sides
                String boxDepth = checkNumber(depthDrawer);

                ArrayList<String> sides1 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "5", "H", "x", boxDepth,
                        "W", "", "", "", "Drawer Sides",
                        type, client, "White", color));

                ArrayList<String> sides234 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 6),
                        "6 1/4", "H", "x", boxDepth,
                        "W", "", "", "", "Drawer Sides",
                        type, client, "White", color));

                ArrayList<String> sides5 = new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        "7 1/2", "H", "x", boxDepth,
                        "W", "", "", "", "Drawer Sides",
                        type, client, "White", color));

                box.add(frontAndBack1);
                box.add(frontAndBack234);
                box.add(frontAndBack5);
                box.add(sides1);
                box.add(sides234);
                box.add(sides5);
            }
        }



        return box;
    }

    public static ArrayList<String> boxBottoms(int partMultiplier, String depthDrawer, String widthDrawer, String type, String client, String notes) {
        double depth = convertFractionToDecimal(depthDrawer);

        if (depth >= 11.75 && depth <= 13.625) {
            depthDrawer = String.valueOf(11.75);
        }
        if (depth >= 13.75 && depth <= 15.625) {
            depthDrawer = String.valueOf(13.75);
        }
        if (depth >= 15.75 && depth <= 17.625) {
            depthDrawer = String.valueOf(15.75);
        }
        if (depth >= 17.75 && depth <= 19.625) {
            depthDrawer = String.valueOf(17.75);
        }
        if (depth >= 19.75 && depth <= 21.625) {
            depthDrawer = String.valueOf(19.75);
        }
        if (depth >= 21.75 && depth <= 23.625) {
            depthDrawer = String.valueOf(21.75);
        }
        if (depth >= 23.75 && depth <= 25.625) {
            depthDrawer = String.valueOf(23.75);
        }

        return new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 5), "", "", "",
                checkNumber(depthDrawer), "D", "x",
                checkNumber(sub(widthDrawer, "2.5625")),
                "W", "Drawer Bottom (1/4')",
                type, client, notes, "White"));
    }
}
