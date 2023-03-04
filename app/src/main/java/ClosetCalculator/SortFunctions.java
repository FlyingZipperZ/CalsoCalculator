package ClosetCalculator;

import java.util.ArrayList;
import java.util.Objects;

import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimal;

public class SortFunctions {
    public static ArrayList<ArrayList<String>> sortReversed(int location, ArrayList<ArrayList<String>> list) {
        for(int i=0; i < list.size()-1; i+=1){
            int m = i;
            for(int j=i+1; j < list.size(); j+=1){
                if (!list.get(m).get(1).isEmpty() && !list.get(j).get(1).isEmpty()) {
                    if (convertFractionToDecimal(list.get(m).get(location)) <
                            convertFractionToDecimal(list.get(j).get(location))) {
                        m = j;
                    }
                }
            }
            ArrayList<String> temp = list.get(m);
            list.set(m, list.get(i));
            list.set(i, temp);
        }
        return list;
    }

    public static ArrayList<ArrayList<String>> sortReversed2d(ArrayList<ArrayList<String>> list) {
        for(int i=0; i < list.size()-1; i+=1){
            int m = i;
            for(int j=i+1; j < list.size(); j+=1) {
                if (convertFractionToDecimal(list.get(m).get(1)) == 0) {
                    if (!list.get(m).get(7).isEmpty() && !list.get(j).get(7).isEmpty()) {
                        if (convertFractionToDecimal(list.get(m).get(4)) <
                                convertFractionToDecimal(list.get(j).get(4))) {
                            m = j;
                        } else if (convertFractionToDecimal(list.get(m).get(7)) <
                                convertFractionToDecimal(list.get(j).get(7))) {
                            m = j;
                        }
                    }
                } else {
                    if (!list.get(m).get(1).isEmpty() && !list.get(j).get(1).isEmpty()) {
                        if (convertFractionToDecimal(list.get(m).get(1)) <
                                convertFractionToDecimal(list.get(j).get(1))) {
                            m = j;
                        } else if (convertFractionToDecimal(list.get(m).get(4)) <
                                convertFractionToDecimal(list.get(j).get(4))) {
                            m = j;
                        }
                    }
                }
            }
            ArrayList<String> temp = list.get(m);
            list.set(m, list.get(i));
            list.set(i, temp);
        }
        return list;
    }
}
