package ClosetCalculator.Calculations;

import static ClosetCalculator.Calculations.DecimalToFraction.convertDecimalToFraction;

public class AddToString {
    public static String add(String number, String subNumber) {

        String inch = null;

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        String[] charSubNum = subNumber.split("\\.");

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        if(number.contains(" ")) {
            String[] charNum = number.split(" ");
            String[] charDiv = charNum[1].split("/");
            int numerator = Integer.parseInt(charDiv[0]);
            int denominator = Integer.parseInt(charDiv[1]);
            double fraction = (double) numerator/denominator;
            inch = charNum[0] + " " + convertDecimalToFraction(fraction - Double.parseDouble("." + charSubNum[1]));
        } else if(number.contains(".")) {
            String[] charNum = number.split("\\.");
            inch = charNum[0] + "" + convertDecimalToFraction(Double.parseDouble("." + charNum[1]) - Double.parseDouble("." + charSubNum[1]));
        } else {
            int value = Integer.parseInt(number) + Integer.parseInt(charSubNum[0]);
//            value--;
            inch = value + " " + convertDecimalToFraction(1 - Double.parseDouble("." + charSubNum[1]));
        }

        return inch;
    }
}
