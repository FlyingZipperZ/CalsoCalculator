package ClosetCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;


public class ColorMatch {
    public static int getNumberOfColors(ArrayList<ArrayList<String>> list) {
        int colorNum = 1;
        String color = list.get(0).get(13);

        System.out.println("Number of Colors");
        for (ArrayList<String> strings : list) {
            if (!Objects.equals(strings.get(13), color)) {
                color = strings.get(13);
                colorNum++;
            }
        }

        System.out.println(colorNum);

        return colorNum;
    }
}
