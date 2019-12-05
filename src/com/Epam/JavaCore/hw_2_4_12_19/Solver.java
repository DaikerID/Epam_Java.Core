package com.Epam.JavaCore.hw_2_4_12_19;

public class Solver {
    public static void solve(QuadraticEquation quadraticEquation) {
        if (quadraticEquation.getA() != 0) {
            double discriminant = calculateDiscriminant(quadraticEquation);
            boolean isDiscriminantPositive = discriminant > 0;
            boolean isDiscriminantZero = discriminant == 0;

            if (isDiscriminantZero) {
                calculateSingleRoot(quadraticEquation);
            } else if (isDiscriminantPositive) {
                calculateTwoRoots(quadraticEquation, discriminant);
            } else {
                System.out.println("The equation" + quadraticEquation + " has no solutions!");
            }
        } else {
            System.out.println("'a' cannot be zero");
        }
    }

    private static double calculateDiscriminant(QuadraticEquation quadraticEquation) {
        return Math.pow(quadraticEquation.getB(), 2) - 4 * quadraticEquation.getA() * quadraticEquation.getC();
    }

    private static void calculateTwoRoots(QuadraticEquation quadraticEquation, double discriminant) {
        double x1 = (-quadraticEquation.getB() + Math.sqrt(discriminant)) / (2 * quadraticEquation.getA());
        double x2 = (-quadraticEquation.getB() - Math.sqrt(discriminant)) / (2 * quadraticEquation.getA());
        System.out.print("The roots of equation " + quadraticEquation + ":\n1)" + x1 + "\n2)" + x2);
    }

    private static void calculateSingleRoot(QuadraticEquation quadraticEquation) {
        double x = -quadraticEquation.getB() / 2 * quadraticEquation.getA();
        System.out.println("Single root of equation " + quadraticEquation + " - " + x);
    }
}
