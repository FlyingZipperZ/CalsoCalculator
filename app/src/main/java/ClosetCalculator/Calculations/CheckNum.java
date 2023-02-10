package ClosetCalculator.Calculations;

import static ClosetCalculator.Calculations.DecimalToFraction.convertDecimalToFraction;

public class CheckNum {
    public static String checkNumber(String number) {
        if(number.contains(" ")) {
            return number;
        } else if (number.isEmpty()) {
            return "";
        } else {
            return convertDecimalToFraction(Double.parseDouble(number));
        }
    }
}
