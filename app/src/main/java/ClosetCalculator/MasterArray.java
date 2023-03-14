package ClosetCalculator;

import java.util.ArrayList;
import java.util.Objects;

import static ClosetCalculator.ColorMatch.getNumberOfColors;

public class MasterArray {
    public static ArrayList<ArrayList<ArrayList<String>>> createMasterArray(ArrayList<ArrayList<String>> masterList) {
        ArrayList<ArrayList<ArrayList<String>>> unitColor = new ArrayList<>();

        int colorNum = getNumberOfColors(masterList);
        int arrayY = 0;
        String color = masterList.get(0).get(13);
        int masterListY = 0;

        unitColor.add(new ArrayList<ArrayList<String>>());
        // Add different units to different axis
        for (int arrayX = 0; arrayX < colorNum; arrayX++) {
            System.out.println("*************************** Color: " + color + " ***************************");
            if (masterList.size() > arrayX + 1) {
//                if (!Objects.equals(masterList.get(arrayX).get(1), masterList.get(arrayX + 1).get(1))) {
                    arrayY = 0;
                    unitColor.add(new ArrayList<ArrayList<String>>()); // runs as many times as the colorNum allows
//                }
            }
            while (Objects.equals(color, masterList.get(masterListY).get(13))) {
                unitColor.get(arrayX).add(new ArrayList<>());
                unitColor.get(arrayX).set(arrayY, masterList.get(masterListY));
                if (masterListY < masterList.size() - 1) {
                    masterListY++;
                    arrayY++;
                } else {
                    break;
                }
            }
            color = masterList.get(masterListY).get(13);
        }
        return unitColor;
    }
}
