package ClosetCalculator.Calculations.DrawerUnits.FX;

import java.util.ArrayList;
import java.util.List;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.SubtractFromString.sub;
import static ClosetCalculator.Calculations.SubtractFromString.subHalfInch;

public class DrawerFXBox {
    public static ArrayList<ArrayList<String>> calcFace(int partMultiplier, String faceWidth, String type, String client, String notes) {

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> faces = new ArrayList<>();

        // Faces
        ArrayList<String> face = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                "6 1/4", "H","x", faceWidth, "W", "",
                "", "", "Face",
                type, client, notes));

        // Faces
        ArrayList<String> face234 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 3),
                "7 1/5", "H","x", faceWidth, "W", "",
                "", "", "Face",
                type, client, notes));

        // Faces
        ArrayList<String> face5 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                "8 3/4", "H","x", faceWidth, "W", "",
                "", "", "Face",
                type, client, notes));
        faces.add(face);
        faces.add(face234);
        faces.add(face5);

        return faces;
    }

    public static ArrayList<ArrayList<String>> calcBox(int partMultiplier, String widthDrawer, String type, String client, String notes, String depthDrawer) {

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> box = new ArrayList<>();

        /**
         *  Drawer boxes
         */
        String boxWidth = checkNumber(sub(widthDrawer, "4.0625"));
        // Front and back
        ArrayList<String> frontAndBack1 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "5", "H", "x", boxWidth,
                "W", "", "", "", "Drawer Sides",
                type, client, notes));

        ArrayList<String> frontAndBack234 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 6),
                "6 1/4", "H", "x", boxWidth,
                "W", "", "", "", "Drawer Sides",
                type, client, notes));

        ArrayList<String> frontAndBack5 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "7 1/2", "H", "x", boxWidth,
                "W", "", "", "", "Drawer Sides",
                type, client, notes));

        // Sides
        String boxDepth = checkNumber(subHalfInch(depthDrawer));
        ArrayList<String> sides1 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "5", "H", "x", boxDepth,
                "W", "", "", "", "Drawer F&B",
                type, client, notes));

        ArrayList<String> sides234 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 6),
                "6 1/4", "H", "x", boxDepth,
                "W", "", "", "", "Drawer F&B",
                type, client, notes));

        ArrayList<String> sides5 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "7 1/2", "H", "x", boxDepth,
                "W", "", "", "", "Drawer F&B",
                type, client, notes));

        box.add(frontAndBack1);
        box.add(frontAndBack234);
        box.add(frontAndBack5);
        box.add(sides1);
        box.add(sides234);
        box.add(sides5);

        return box;
    }
    public static ArrayList<String> calcBottom(int partMultiplier, String depthDrawer, String widthDrawer, String type, String client, String notes) {
        return new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 5), "", "", "",
                checkNumber(subHalfInch(depthDrawer)), "D", "x",
                checkNumber(sub(widthDrawer, "2.5625")),
                "W", "Drawer Bottom (1/4')",
                type, client, notes));
    }
}
