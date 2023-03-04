package ClosetCalculator.Calculations.DrawerUnits;

import ClosetCalculator.Calculations.SubtractFromString;
import ClosetCalculator.SortFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ClosetCalculator.Calculations.AddToString.addNumbers;
import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.DrawerUnits.AddShelve.addShelves;
import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimal;
import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class DrawerDS23 {
    public static ArrayList<ArrayList<String>> createDS23(ArrayList<ArrayList<String>> drawerListDS23) {

        SortFunctions.sortReversed(1, drawerListDS23);

        System.out.println("Input");
        for (int i = 0; i < drawerListDS23.size(); i++) {
            System.out.println(drawerListDS23.get(i));
        }

        // Create top and bottom arraylist
        ArrayList<String> top = new ArrayList<>();

        ArrayList<String> bottom = new ArrayList<>();

        ArrayList<String> uprights = new ArrayList<>();

        ArrayList<ArrayList<String>> face = new ArrayList<>();

        ArrayList<ArrayList<String>> frontAndBack = new ArrayList<>();

        ArrayList<ArrayList<String>> sides = new ArrayList<>();

        ArrayList<ArrayList<String>> bottomBox = new ArrayList<>();

        ArrayList<ArrayList<ArrayList<String>>> drawers = new ArrayList<>();

        int arrayY = 0;
        int arrayZ = 0;
//        System.out.println();
        drawers.add(new ArrayList<ArrayList<String>>());
        // Add different units to different axis
        for (int x = 0; x < drawerListDS23.size(); x++) {
            drawers.get(arrayZ).add(arrayY++, drawerListDS23.get(x));
            if (drawerListDS23.size() > x+1) {
                if (!Objects.equals(drawerListDS23.get(x).get(1), drawerListDS23.get(x + 1).get(1))) {
                    arrayY = 0;
                    arrayZ++;
                    drawers.add(new ArrayList<ArrayList<String>>());
                }
            }
        }

        double heightDrawer = 0;
        double depth = 0;

        // height created for uprights
        int locationPart = 0;
        int locationWidth = 1;
        int locationHeight = 2;
        int locationDepth = 3;
        int locationType = 4;
        int locationShelveNumber = 6;
        int locationClient = 8;
        int locationColor = 9;

        String drawerWidth = "";
        String drawerHeight = "";
        String drawerDepth = "";
        String drawerType = "";
        String drawerClient = "";
        String drawerColor = "";

        int shelveNumber = 0;

        // Get widths of all different z axis parts
        for (int z = 0; z < drawers.size(); z++) {
            depth = convertFractionToDecimal(drawers.get(z).get(0).get(locationDepth));
            for (int y = 0; y < drawers.get(z).size(); y++) {

                // Sub the 0.5
                String faceWidth = sub(drawers.get(z).get(0).get(locationWidth), "0.5");

                int partMultiplier = Integer.parseInt(drawers.get(z).get(0).get(locationPart));
                for (int x = 0; x < partMultiplier; x++) {
                    heightDrawer += convertFractionToDecimal(drawers.get(z).get(y).get(locationHeight));
                    if (!drawers.get(z).get(y).get(locationShelveNumber).isEmpty()) {
                        shelveNumber += Integer.parseInt(drawers.get(z).get(y).get(locationShelveNumber));
                    }
                }

                drawerWidth = checkNumber(drawers.get(z).get(y).get(locationWidth));
                drawerHeight = addNumbers(checkNumber(drawers.get(z).get(y).get(locationHeight)), drawerHeight);
                drawerDepth = checkNumber(drawers.get(z).get(y).get(locationDepth));
                drawerType = drawers.get(z).get(y).get(locationType);
                drawerClient = drawers.get(z).get(y).get(locationClient);
                drawerColor = drawers.get(z).get(y).get(locationColor);

                // Faces
                face.add(new ArrayList<>(List.of(
                        String.valueOf(partMultiplier),
                        drawerHeight, "H","x", checkNumber(faceWidth), "W", "",
                        "", "", "Face",
                        drawerType,
                        drawerClient,
                        drawerColor)));

                String boxWidth = checkNumber(sub(drawerWidth, "4.0625"));
                String boxHeight = checkNumber(sub(String.valueOf(heightDrawer), "1.25"));
                String boxDepth = checkNumber(sub(drawerDepth, "0.25"));
                String boxBottomWith = checkNumber(sub(drawerWidth, "2.5625"));

                frontAndBack.add(new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        boxHeight, "H","x", boxWidth, "W",
                        "", "", "", "Drawer F&B",
                        drawerType,
                        drawerClient,
                        drawerColor
                )));

                sides.add(new ArrayList<>(List.of(
                        String.valueOf(partMultiplier * 2),
                        boxHeight, "H","x", boxDepth, "W",
                        "", "", "", "Drawer Sides",
                        drawerType,
                        drawerClient,
                        drawerColor
                )));

                bottomBox.add(new ArrayList<>(List.of(
                        String.valueOf(1),  "", "", "",
                        SubtractFromString.subHalfInch(drawerDepth), "D","x",
                        boxBottomWith,
                        "W", "Drawer Bottom (1/4')",
                        drawerType,
                        drawerClient,
                        drawerColor
                )));
            }

            // Create top and bottom arraylist
            top = new ArrayList<>(List.of(
                    String.valueOf(1),
                    drawerDepth, "D","x", drawerWidth, "W", "",
                    "", "", "Top",
                    drawerType,
                    drawerClient,
                    drawerColor
            ));

            // Create top and bottom arraylist
            bottom = new ArrayList<>(List.of(
                    String.valueOf(1),
                    drawerDepth, "D","x", drawerWidth, "W", "",
                    "", "", "Bottom",
                    drawerType,
                    drawerClient,
                    drawerColor
            ));

            String depthInput = "";
            if (depth % 1 == 0) {
                depthInput = String.valueOf((int)depth);
            } else {
                depthInput = String.valueOf(depth);
            }

            uprights = new ArrayList<>(List.of(String.valueOf(2),
                    "", "", "",
                    checkNumber(depthInput), "D", "x",
                    drawerHeight, "H", "Upright/WH",
                    drawerType,
                    drawerClient,
                    drawerColor
            ));

            heightDrawer = 0;
        }

        ArrayList<ArrayList<String>> drawer23 = new ArrayList<>();

        drawer23.add(top);
        drawer23.add(bottom);
        drawer23.addAll(face);
        drawer23.addAll(frontAndBack);
        drawer23.addAll(sides);
        drawer23.add(uprights);
        drawer23.addAll(bottomBox);

        if (shelveNumber > 0) {
            drawer23.add(addShelves(shelveNumber, top));
        }

        return drawer23;
    }
}
