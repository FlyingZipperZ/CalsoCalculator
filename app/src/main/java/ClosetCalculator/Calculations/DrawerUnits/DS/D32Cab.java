package ClosetCalculator.Calculations.DrawerUnits.DS;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;

public class D32Cab {
    /**
     * Drawer Outside box
     * @param vector
     */
    public static ArrayList<ArrayList<String>> createD32(Vector vector) {

        ArrayList<String> drawer = new ArrayList<>(vector.stream().toList());
        ArrayList<ArrayList<String>> unit = new ArrayList<>();

        String numberParts = drawer.get(0);
        String widthDrawer = checkNumber(drawer.get(1));
        String heightDrawer = checkNumber(drawer.get(2));
        String depthDrawer = checkNumber(drawer.get(3));
        String type = drawer.get(4);
//        String rod = drawers.get(5);
        String noShel = drawer.get(6);
        String client = drawer.get(7);
        String notes = drawer.get(8);
        String color = drawer.get(9);
//        String topOption = drawers.get(10);
//        String botOption = drawers.get(11);

        int partMultiplier = Integer.parseInt(numberParts);

        // Create top and bottom arraylist
        ArrayList<String> top = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                depthDrawer, "D","x", widthDrawer, "W",
                "", "", "",
                "Top", type, client, notes, color));

        ArrayList<String> bottom = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                "0", "", "",
                depthDrawer, "D","x",
                widthDrawer, "W", "Bottom",
                type, client, notes, color));

        // Create upright arraylist
        ArrayList<String> upright = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "0", "", "",
                depthDrawer, "D","x",
                heightDrawer, "H","Upright/WH",
                type, client, "CNC-1/4", "White"));

        if (!noShel.isEmpty()) {
            ArrayList<String> shelves = new ArrayList<>(List.of(
                    String.valueOf(noShel),
                    depthDrawer, "D", "x", widthDrawer, "W",
                    "", "", "",
                    "Shelves", type, client, "", "White"));
            unit.add(shelves);
        }

        unit.add(top);
        unit.add(bottom);
        unit.add(upright);



        return unit;
    }
}
