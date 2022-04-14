package Lesson4;
// HomeWork 4

public class AreaTriangle {
    public static double areaOfTriangle(double a, double b, double c) {
        double p = (a + b + c)/2;
        double result = Math.sqrt(p*(p - a)*(p - b)*(p -c));
        return result;
    }
}
