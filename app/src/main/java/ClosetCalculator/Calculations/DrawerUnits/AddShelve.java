package ClosetCalculator.Calculations.DrawerUnits;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static ClosetCalculator.Calculations.SubtractFromString.sub8thInch;

public class AddShelve {
    public static ArrayList<String> addShelves(int shelveNumber, ArrayList<String> top) {

        return new ArrayList<>(List.of(
                String.valueOf(shelveNumber),
                top.get(1), "D", "x",  sub8thInch(top.get(4)), "W", "",
                "", "", "",
                "s", top.get(11), top.get(12)
        ));
    }

    public static ArrayList<String> addShelves(Vector vector) {

        // ArrayList that holds data for the shelves incoming
        ArrayList<String> shelvesList = new ArrayList<>(vector.stream().toList());

        String noShel = shelvesList.get(6);

        return new ArrayList<>(List.of(
                noShel,
                shelvesList.get(3), "D", "x",  sub8thInch(shelvesList.get(1)), "W", "",
                "", "", "",
                "s", shelvesList.get(8), shelvesList.get(9)));
    }
}
