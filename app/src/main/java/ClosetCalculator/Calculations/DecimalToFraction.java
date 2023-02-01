package ClosetCalculator.Calculations;

public class DecimalToFraction {
    static String convertDecimalToFraction(double x) {
        if (x < 1) {
            if (x < 0) {
                return "-" + convertDecimalToFraction(-x);
            }
            double tolerance = 1.0E-6;
            double h1 = 1;
            double h2 = 0;
            double k1 = 0;
            double k2 = 1;
            double b = x;
            do {
                double a = Math.floor(b);
                double aux = h1;
                h1 = a * h1 + h2;
                h2 = aux;
                aux = k1;
                k1 = a * k1 + k2;
                k2 = aux;
                b = 1 / (b - a);
            } while (Math.abs(x - h1 / k1) > x * tolerance);

            if (((int) h1 + "/" + (int) k1).equals("0/1")) {
                return "";
            } else {
                return " " + (int) h1 + "/" + (int) k1;
            }
        } else {
            double number = Math.floor(x);
            x -= number;
            convertDecimalToFraction(x);
            return (int) number + convertDecimalToFraction(x);
        }
    }
}
