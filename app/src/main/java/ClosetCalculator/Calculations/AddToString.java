package ClosetCalculator.Calculations;

import static ClosetCalculator.Calculations.DecimalToFraction.convertDecimalToFraction;
import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimal;

public class AddToString {
    public static String add(String number, String subNumber) {

        String inch = null;

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        String[] charSubNum = subNumber.split("\\.");

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        if(number.contains(" ")) {
            inch = convertDecimalToFraction(convertFractionToDecimal(number) + convertFractionToDecimal(subNumber));
        } else {
            double value = Double.parseDouble(number) + Double.parseDouble(subNumber);
            if (value % 1 == 0) {
                inch = String.valueOf((int)value);
            } else {
                inch = String.valueOf(value);
            }
        }
        return inch;
    }
}
