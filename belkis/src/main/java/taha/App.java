package taha;

import java.util.Scanner;

public class App {
    private static final String REAL_DISTINCT_ROOTS_MESSAGE = "The roots of the equation are real and distinct:";
    private static final String REAL_EQUAL_ROOTS_MESSAGE = "The roots of the equation are real and equal:";
    private static final String COMPLEX_ROOTS_MESSAGE = "The roots of the equation are complex:";
    private static final String ROOT_FORMAT = "Root %d = ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coefficients of the quadratic equation (a, b, c):");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.println(solveQuadraticEquation(a, b, c));

        scanner.close();
    }
    /**
     * This method adds two integers and returns the result.
     * @param a The first integer to be added
     * @param b The second integer to be added
     * @return The multiple of a and b
     */
    public static String solveQuadraticEquation(double a, double b, double c) {
        double discriminant = calculateDiscriminant(a, b, c);
        StringBuilder result = new StringBuilder();

        if (discriminant > 0) {
            appendRealDistinctRoots(result, a, b, discriminant);
        } else if (discriminant == 0) {
            appendRealEqualRoots(result, a, b);
        } else {
            appendComplexRoots(result, a, b, discriminant);
        }

        return result.toString();
    }

    private static double calculateDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    private static void appendRealDistinctRoots(StringBuilder result, double a, double b, double discriminant) {
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        appendRootMessage(result, REAL_DISTINCT_ROOTS_MESSAGE);
        appendRoot(result, root1, 1);
        appendRoot(result, root2, 2);
    }

    private static void appendRealEqualRoots(StringBuilder result, double a, double b) {
        double root = -b / (2 * a);
        appendRootMessage(result, REAL_EQUAL_ROOTS_MESSAGE);
        appendRoot(result, root, 1);
    }

    private static void appendComplexRoots(StringBuilder result, double a, double b, double discriminant) {
        double realPart = -b / (2 * a);
        double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
        appendRootMessage(result, COMPLEX_ROOTS_MESSAGE);
        appendComplexRoot(result, realPart, imaginaryPart, 1);
        appendComplexRoot(result, realPart, -imaginaryPart, 2);
    }

    private static void appendRootMessage(StringBuilder result, String message) {
        result.append(message).append("\n");
    }

    private static void appendRoot(StringBuilder result, double root, int index) {
        result.append(String.format(ROOT_FORMAT, index)).append(root).append("\n");
    }

    private static void appendComplexRoot(StringBuilder result, double realPart, double imaginaryPart, int index) {
        result.append(String.format(ROOT_FORMAT, index))
              .append(realPart)
              .append(" + ")
              .append(imaginaryPart)
              .append("i\n");
    }
}
