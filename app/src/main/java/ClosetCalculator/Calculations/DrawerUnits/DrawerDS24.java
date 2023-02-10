package ClosetCalculator.Calculations.DrawerUnits;

import ClosetCalculator.Calculations.DecimalToFraction;
import ClosetCalculator.Calculations.FractionToDecimal;
import ClosetCalculator.Calculations.SubtractFromString;
import ClosetCalculator.SortFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ClosetCalculator.Calculations.AddToString.add;
import static ClosetCalculator.Calculations.DecimalToFraction.convertDecimalToFraction;

public class DrawerDS24 {
    public static ArrayList<ArrayList<String>> createDS24(ArrayList<ArrayList<String>> drawerListds24) {

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

        SortFunctions.sortReversed(1, drawerListds24);

        System.out.println("Input");
        for (int i = 0; i < drawerListds24.size(); i++) {
            System.out.println(drawerListds24.get(i));
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
        for (int x = 0; x < drawerListds24.size(); x++) {
            drawers.get(arrayZ).add(arrayY++, drawerListds24.get(x));
            if (drawerListds24.size() > x+1) {
                if (!Objects.equals(drawerListds24.get(x).get(1), drawerListds24.get(x + 1).get(1))) {
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
        int locationClient = 8;
        int locationColor = 9;

        // Get widths of all different z axis parts
        for (int z = 0; z < drawers.size(); z++) {
            depth = FractionToDecimal.convertFractionToDecimal(drawers.get(z).get(0).get(locationDepth));
            for (int y = 0; y < drawers.get(z).size(); y++) {

                // Sub the 0.5
                String faceWidth = add(drawers.get(z).get(0).get(locationWidth), "0.5");

                int partMultiplier = Integer.parseInt(drawers.get(z).get(0).get(locationPart));
                for (int multi = 0; multi < partMultiplier; multi++) {
                    heightDrawer += FractionToDecimal.convertFractionToDecimal(drawers.get(z).get(y).get(locationHeight));
                }

                String drawerWidth = drawers.get(z).get(y).get(locationWidth);
                String drawerHeight = drawers.get(z).get(y).get(locationHeight);
                String drawerDepth = drawers.get(z).get(y).get(locationDepth);
                String drawerType = drawers.get(z).get(y).get(locationType);
                String drawerClient = drawers.get(z).get(y).get(locationClient);
                String drawerColor = drawers.get(z).get(y).get(locationColor);

                // Faces
                face.add(new ArrayList<>(List.of(
                        String.valueOf(partMultiplier),
                        drawerHeight, "H","x", faceWidth, "W", "",
                        "", "", "Face",
                        drawerType,
                        drawerClient,
                        drawerColor)));

                String boxWidth = SubtractFromString.sub(drawerWidth, "4.0625");
                String boxHeight = SubtractFromString.sub(drawerHeight, "1.25");
                String boxDepth = SubtractFromString.sub(drawerDepth, "0.25");
                String boxBottomWith = SubtractFromString.sub(drawerWidth, "2.5625");

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
                    drawers.get(z).get(0).get(locationDepth), "D","x", drawers.get(z).get(0).get(locationWidth), "W", "",
                    "", "", "Top",
                    drawers.get(z).get(0).get(locationType),
                    drawers.get(z).get(0).get(locationClient),
                    drawers.get(z).get(0).get(locationColor)));

            // Create top and bottom arraylist
            bottom = new ArrayList<>(List.of(
                    String.valueOf(1),
                    drawers.get(z).get(0).get(locationDepth), "D","x", drawers.get(z).get(0).get(locationWidth), "W", "",
                    "", "", "Bottom",
                    drawers.get(z).get(0).get(locationType),
                    drawers.get(z).get(0).get(locationClient),
                    drawers.get(z).get(0).get(locationColor)));

            String depthInput = "";
            if (depth % 1 == 0) {
                depthInput = String.valueOf((int)depth);
            } else {
                depthInput = String.valueOf(depth);
            }
            uprights = new ArrayList<>(List.of(String.valueOf(2),
                    "", "", "",
                    SubtractFromString.sub(depthInput, "0.25"), "D", "x",
                    convertDecimalToFraction(heightDrawer), "H", "Upright/WH",
                    drawers.get(z).get(0).get(locationType),
                    drawers.get(z).get(0).get(locationClient),
                    drawers.get(z).get(0).get(locationColor)
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

        return drawer23;
    }
}
