package ClosetCalculator.Calculations.DrawerUnits.Kar;

import java.util.ArrayList;
import java.util.List;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.SubtractFromString.*;
import static ClosetCalculator.SortFunctions.sortReversed;

public class DrawerKarBox {
    public static ArrayList<ArrayList<String>> calcFaceKAR(int partMultiplier, String faceWidth, String type,
                                                        String client, String notes, String color) {

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> faces = new ArrayList<>();

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

        return faces;
    }

    public static ArrayList<ArrayList<String>> calcBoxKAR(int partMultiplier, String widthDrawer, String type,
                                                          String client, String notes, String depthDrawer) {

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> box = new ArrayList<>();

        /**
         *  Drawer boxes
         */
        String boxWidth = checkNumber(sub(widthDrawer, "4.0625"));
        // Front and back
        ArrayList<String> frontAndBack1 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "5", "H","x", boxWidth,
                "W", "", "", "", "Drawer Sides",
                type, client, notes, "White"));

        ArrayList<String> frontAndBack234 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "6 1/4", "H","x", boxWidth,
                "W", "", "", "", "Drawer Sides",
                type, client, notes, "White"));

        ArrayList<String> frontAndBack5 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "7 1/2", "H","x", boxWidth,
                "W", "", "", "", "Drawer Sides",
                type, client, notes, "White"));

        // Sides
        String boxDepth = checkNumber(sub(depthDrawer, "0.125"));
        ArrayList<String> sides1 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "5", "H","x", boxDepth,
                "W", "", "", "", "Drawer F&B",
                type, client, notes, "White"));

        ArrayList<String> sides234 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "6 1/4", "H","x", boxDepth,
                "W", "", "", "", "Drawer F&B",
                type, client, notes, "White"));

        ArrayList<String> sides5 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "7 1/2", "H","x", boxDepth,
                "W", "", "", "", "Drawer F&B",
                type, client, notes, "White"));

        box.add(frontAndBack1);
        box.add(frontAndBack234);
        box.add(frontAndBack5);
        box.add(sides1);
        box.add(sides234);
        box.add(sides5);

        return box;
    }

    public static ArrayList<String> calcBottomKAR(int partMultiplier, String depthDrawer, String widthDrawer, String type, String client, String notes) {
        return new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 5),  "", "", "",
                checkNumber(depthDrawer), "D","x",
                checkNumber(sub(widthDrawer, "2.5625")),
                "W", "Drawer Bottom (1/4')",
                type, client, notes, "White"));
    }
}
