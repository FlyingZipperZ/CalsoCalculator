package ClosetCalculator;

import ClosetCalculator.Calculations.FractionToDecimal;

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

    public static ArrayList<ArrayList<String>> sort(int location, ArrayList<ArrayList<String>> list) {
        for(int i=0; i < list.size()-1; i+=1){
            int m = i;
            for(int j=i+1; j < list.size(); j+=1){
                if(convertFractionToDecimal(list.get(m).get(location)) >
                        convertFractionToDecimal(list.get(j).get(location))) {
                    m = j;
                }
            }

            ArrayList<String> temp = list.get(m);
            list.set(m, list.get(i));
            list.set(i, temp);
        }
        return list;
    }

    public static void bubbleSort(int location, ArrayList<ArrayList<String>> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            for (int j = 0; j < list.size() - i -1; j++)
            {
//                if (Objects.equals(list.get(i).get(location), "") || Objects.equals(list.get(j).get(location), "")) {
//
////                    ArrayList<String> temp = list.get(j + 1);
////                    list.set(j + 1, list.get(j));
////                    list.set(j, temp);
//                } else {
                    if (convertFractionToDecimal(list.get(i).get(location)) >
                            convertFractionToDecimal(list.get(j).get(location))) {

                        ArrayList<String> temp = list.get(j + 1);
                        list.set(j + 1, list.get(j));
                        list.set(j, temp);
                    }
//                }
            }
        }
    }

    public static void bubbleSortReversed(int location, ArrayList<ArrayList<String>> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            for (int j = 0; j < list.size() - i -1; j++)
            {
                if (Objects.equals(list.get(i).get(location), "") || Objects.equals(list.get(j).get(location), "")) {
                    ArrayList<String> temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                } else {
                    if (convertFractionToDecimal(list.get(i).get(location)) <
                            convertFractionToDecimal(list.get(j).get(location))) {

                        ArrayList<String> temp = list.get(j + 1);
                        list.set(j + 1, list.get(j));
                        list.set(j, temp);
                    }
                }
            }
        }
    }
}
