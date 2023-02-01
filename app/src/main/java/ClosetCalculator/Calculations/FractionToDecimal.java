package ClosetCalculator.Calculations;

public class FractionToDecimal {
    public static double convertFractionToDecimal(String value){
        if (value.contains(" ")) {
            String[] charnum = value.split(" ");
            String[] frac = charnum[1].split("/");

            double fraction = Double.parseDouble(frac[0]) / Double.parseDouble(frac[1]);
            return Double.parseDouble(charnum[0]) + fraction;
        }
        else if (value.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(value);
    }

    public static double convertFractionToDecimalRods(String value){
        if (value.contains("/")) {
            String[] charnum = value.split("/");

            return Double.parseDouble(charnum[0]) / Double.parseDouble(charnum[1]);
                    }
        else if (value.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(value);
    }
}
