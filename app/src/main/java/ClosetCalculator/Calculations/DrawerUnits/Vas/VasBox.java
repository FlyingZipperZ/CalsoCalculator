package ClosetCalculator.Calculations.DrawerUnits.Vas;

import java.util.ArrayList;
import java.util.List;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.SubtractFromString.sub;
import static ClosetCalculator.Calculations.SubtractFromString.subHalfInch;
import static ClosetCalculator.SortFunctions.sortReversed;

public class VasBox {
    public static ArrayList<ArrayList<String>> calcFaceVas(int partMultiplier, String faceWidth, String type,
                                                          String client, String notes, String color) {

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> faces = new ArrayList<>();

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

        return faces;
    }

    public static ArrayList<ArrayList<String>> calcBoxVas(int partMultiplier, String widthDrawer, String type,
                                                         String client, String notes, String depthDrawer) {

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> box = new ArrayList<>();

        /**
         *  Drawer boxes
         */
        String boxWidth = checkNumber(sub(widthDrawer, "4.0625"));
        // Front and back
        ArrayList<String> frontAndBack123 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 6),
                "6 1/4", "H", "x", boxWidth,
                "W", "", "", "", "Drawer Sides",
                type, client, notes, "White"));

        ArrayList<String> frontAndBack45 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "7 1/2", "H", "x", boxWidth,
                "W", "", "", "", "Drawer Sides",
                type, client, notes, "White"));

        // Sides
        String boxDepth = checkNumber(sub(depthDrawer, "0.125"));

        ArrayList<String> sides123 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 6),
                "6 1/4", "H", "x", boxDepth,
                "W", "", "", "", "Drawer F&B",
                type, client, notes, "White"));

        ArrayList<String> sides45 = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 4),
                "7 1/2", "H", "x", boxDepth,
                "W", "", "", "", "Drawer F&B",
                type, client, notes, "White"));

        box.add(frontAndBack123);
        box.add(frontAndBack45);
        box.add(sides123);
        box.add(sides45);

        return box;
    }

    public static ArrayList<String> calcBottomVas(int partMultiplier, String depthDrawer, String widthDrawer, String type, String client, String notes) {
        return new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 5), "", "", "",
                checkNumber(subHalfInch(depthDrawer)), "D", "x",
                checkNumber(sub(widthDrawer, "2.5625")),
                "W", "Drawer Bottom (1/4')",
                type, client, notes, "White"));
    }
}
