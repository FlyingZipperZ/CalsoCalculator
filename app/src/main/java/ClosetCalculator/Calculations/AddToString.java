package ClosetCalculator.Calculations;

import static ClosetCalculator.Calculations.CheckNum.checkNumber;
import static ClosetCalculator.Calculations.DecimalToFraction.convertDecimalToFraction;
import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimal;

public class AddToString {
    public static String add(String number, String addNumber) {

        String inch = null;

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        String[] charSubNum = addNumber.split("\\.");

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        if(number.contains(" ")) {
            inch = convertDecimalToFraction(convertFractionToDecimal(number) + convertFractionToDecimal(addNumber));
        } else {
            double value = Double.parseDouble(number) + Double.parseDouble(addNumber);
            if (value % 1 == 0) {
                inch = String.valueOf((int)value);
            } else {
                inch = String.valueOf(value);
            }
        }
        return inch;
    }

    public static String addNumbers(String number, String addNumber) {
        double num = convertFractionToDecimal(number) + convertFractionToDecimal(addNumber);
        return convertDecimalToFraction(num);
    }
}
