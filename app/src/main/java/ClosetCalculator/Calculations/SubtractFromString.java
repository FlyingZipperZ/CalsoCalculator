package ClosetCalculator.Calculations;

import java.util.Objects;

import static ClosetCalculator.Calculations.DecimalToFraction.convertDecimalToFraction;
import static ClosetCalculator.Calculations.FractionToDecimal.convertFractionToDecimal;

public class SubtractFromString {

    /**
     * Subtracts 1/8 from number depending on how the number is brought in
     * @param number number can come in different formats
     * @return String of number after subtracted
     */
    public static String subHalfInch(String number) {

        String inch;

        double halfInch = (double)1/2;

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        if(number.contains(" ")) {
            String[] charNum = number.split(" ");
            String[] charDiv = charNum[1].split("/");
            int numerator = Integer.parseInt(charDiv[0]);
            int denominator = Integer.parseInt(charDiv[1]);
            double fraction = (double) numerator/denominator;
            inch = charNum[0] + convertDecimalToFraction(fraction  - halfInch);
        } else if(number.contains(".")) {
            String[] charNum = number.split("\\.");
            inch = charNum[0] + convertDecimalToFraction(Double.parseDouble("." + charNum[1])  - halfInch);
        } else {
            int value = Integer.parseInt(number);
            value--;
            inch = value + convertDecimalToFraction(1 - halfInch);
        }
        return inch;
    }

    /**
     * Subtracts subNumber from number depending on how the number is brought in
     * @param number number can come in different formats
     * @param subNumber initialized with a 0.x in front of it
     * @return String of number after subtracted
     */
    public static String sub(String number, String subNumber) {

        String inch;

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        String[] charSubNum = subNumber.split("\\.");

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        if(number.contains(" ")) {
            inch = convertDecimalToFraction(convertFractionToDecimal(number) - convertFractionToDecimal(subNumber));
        } else if(number.contains(".")) {
            String[] charNum = number.split("\\.");
            inch = charNum[0] + convertDecimalToFraction(Double.parseDouble("." + charNum[1]) - Double.parseDouble("." + charSubNum[1]));
        } else {
            int value = Integer.parseInt(number) - Integer.parseInt(charSubNum[0]);
            value--;
            inch = value + convertDecimalToFraction(1 - Double.parseDouble("." + charSubNum[1]));
        }

        return inch;
    }
}
