package ClosetCalculator.Calculations;

import java.util.Objects;

import static ClosetCalculator.Calculations.DecimalToFraction.convertDecimalToFraction;

public class SubtractFromString {
    public static String sub8th(String number) {

        String inch;

        // Checks to see if the number in the shelvesList.get(3) slot has any spaces indicating that there is a fraction
        if(number.contains(" ")) {
            String[] charNum = number.split(" ");
            String[] charDiv = charNum[1].split("/");
            int numerator = Integer.parseInt(charDiv[0]);
            int denominator = Integer.parseInt(charDiv[1]);
            double fraction = (double) numerator/denominator;
            inch = charNum[0] + "" + convertDecimalToFraction(fraction  - (double)1/8);
        } else if(number.contains(".")) {
            String[] charNum = number.split("\\.");
            inch = charNum[0] + "" + convertDecimalToFraction(Double.parseDouble("." + charNum[1])  - (double)1/8);
        } else {
            int value = Integer.parseInt(number);
            value--;
            inch = value + convertDecimalToFraction(1 - (double)1/8);
        }
        return inch;
    }

    public static String sub(String number, String subNumber) {

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
            if (Objects.equals(charNum[0] + " ", inch)) {
                inch = String.valueOf(Integer.parseInt(inch.trim()) - 1);
            } else {
                System.out.println("Fuck");
            }
        } else if(number.contains(".")) {
            String[] charNum = number.split("\\.");
            inch = charNum[0] + "" + convertDecimalToFraction(Double.parseDouble("." + charNum[1]) - Double.parseDouble("." + charSubNum[1]));
        } else {
            int value = Integer.parseInt(number) - Integer.parseInt(charSubNum[0]);
            value--;
            inch = value + convertDecimalToFraction(1 - Double.parseDouble("." + charSubNum[1]));
        }

        return inch;
    }
}
