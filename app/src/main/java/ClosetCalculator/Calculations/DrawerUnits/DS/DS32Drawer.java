package ClosetCalculator.Calculations.DrawerUnits.DS;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class DS32Drawer {
    public static ArrayList<ArrayList<String>> createDS32(Vector vector) {

        ArrayList<String> drawerBox = new ArrayList<>(vector.stream().toList());
        ArrayList<ArrayList<String>> boxes = new ArrayList<>();

        int numberParts = Integer.parseInt(drawerBox.get(0));
        String widthDrawer = checkNumber(drawerBox.get(1));
        String heightDrawer = checkNumber(drawerBox.get(2));
        String depthDrawer = checkNumber(drawerBox.get(3));
        String type = drawerBox.get(4);
//        String rod = drawers.get(5);
//        String noShel = drawerBox.get(6);
        String client = drawerBox.get(7);
        String notes = drawerBox.get(8);
        String color = drawerBox.get(9);
//        String topOption = drawers.get(10);
//        String botOption = drawers.get(11);

        // Faces
        ArrayList<String> face = new ArrayList<>(List.of(
                String.valueOf(numberParts),
                heightDrawer, "H","x", widthDrawer, "W", "",
                "", "", "Face",
                type, client, notes, color));

        /**
         *  Drawer boxes
         */
        String boxWidth = checkNumber(sub(widthDrawer, "4.0625"));
        String boxHeight = checkNumber(sub(heightDrawer, "1.25"));
        String boxDepth = checkNumber(sub(depthDrawer, "0.125"));
        // Front and back
        ArrayList<String> frontAndBack = new ArrayList<>(List.of(
                String.valueOf(numberParts * 2),
                boxHeight, "H", "x", boxWidth, "W",
                "", "", "",
                "Drawer F&B",
                type, client, notes, "White"));

        // Sides
        ArrayList<String> sides = new ArrayList<>(List.of(
                String.valueOf(numberParts * 2),
                boxHeight, "H", "x", boxDepth, "W",
                "", "", "",
                "Drawer Sides",
                type, client, notes, "White"));

        ArrayList<String> bottom = new ArrayList<>(List.of(
                String.valueOf(numberParts), "", "", "",
                checkNumber(depthDrawer), "D", "x",
                checkNumber(sub(widthDrawer, "2.5625")),
                "W", "Drawer Bottom (1/4')",
                type, client, notes, "White"));

        boxes.add(face);
        boxes.add(frontAndBack);
        boxes.add(sides);
        boxes.add(bottom);

        return boxes;
    }


}
