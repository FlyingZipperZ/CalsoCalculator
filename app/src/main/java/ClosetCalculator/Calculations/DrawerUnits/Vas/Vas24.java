package ClosetCalculator.Calculations.DrawerUnits.Vas;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.AddToString.add;
import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.DrawerUnits.AddShelve.addShelves;
import static ClosetCalculator.Calculations.DrawerUnits.Vas.VasBox.*;
import static ClosetCalculator.Calculations.SubtractFromString.sub;

public class Vas24 {
    public static ArrayList<ArrayList<String>> createVas24(Vector vector){
        // ArrayList that holds data for the shelves incoming
        ArrayList<String> drawers = new ArrayList<>(vector.stream().toList());

        String numberParts = drawers.get(0);
        String widthDrawer = checkNumber(drawers.get(1));
//        String heightDrawer = checkNumber(drawers.get(2));
        String depthDrawer = checkNumber(drawers.get(3));
        String type = drawers.get(4);
//        String rod = drawers.get(5);
        String noShel = drawers.get(6);
        String client = drawers.get(7);
        String notes = drawers.get(8);
        String color = drawers.get(9);
//        String topOption = drawers.get(10);
//        String botOption = drawers.get(11);

        int partMultiplier = Integer.parseInt(numberParts);

        // Create top and bottom arraylist
        ArrayList<String> top = new ArrayList<>(List.of(
                String.valueOf(partMultiplier),
                depthDrawer, "D","x", widthDrawer, "W", "",
                "", "", "Top",
                type, client, notes, color));

        ArrayList<String> bottom = new ArrayList<>(List.of(
                String.valueOf(partMultiplier), "", "", "",
                sub(depthDrawer, "0.125"), "D","x", widthDrawer, "W",
                "Bottom",
                type, client, notes, "White"));

        // Create upright arraylist
        ArrayList<String> upright = new ArrayList<>(List.of(
                String.valueOf(partMultiplier * 2),
                "", "", "",
                depthDrawer, "D","x",
                "40", "H","Upright/WH",
                type, client, notes, color));

        // Math when weird number
        String faceWidth = checkNumber(add(widthDrawer, "0.5"));

        //  ArrayList<ArrayList<String>> created to add for output
        ArrayList<ArrayList<String>> drawerUnit = new ArrayList<>();

        drawerUnit.add(top);
        drawerUnit.addAll(calcFaceVas(partMultiplier, faceWidth, type, client, notes, color));
        /**
         *  Drawer boxes
         */
        drawerUnit.addAll(calcBoxVas(partMultiplier, widthDrawer, type, client, notes, depthDrawer));
        drawerUnit.add(upright);
        drawerUnit.add(bottom);
        drawerUnit.add(calcBottomVas(partMultiplier, depthDrawer, widthDrawer, type, client, notes));


        if (!noShel.isEmpty()) {
            drawerUnit.add(addShelves(vector));
        }

        return drawerUnit;
    }
}
