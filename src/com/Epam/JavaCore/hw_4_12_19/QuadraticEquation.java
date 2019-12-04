package com.Epam.JavaCore.hw_4_12_19;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    private String equation;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
        equation = this.a + "x^2 + " + this.b + "x + " + this.c + " = 0 ";
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
        equation = this.a + "x^2 + " + this.b + "x + " + this.c + " = 0 ";
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
        equation = this.a + "x^2 + " + this.b + "x + " + this.c + " = 0 ";
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        equation = this.a + "x^2 + " + this.b + "x + " + this.c + " = 0 ";
    }

    private double calculateDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public void solveEquation() {
        if (this.a != 0) {
            double discriminant = calculateDiscriminant();
            boolean isDiscriminantPositive = discriminant > 0;
            boolean isDiscriminantZero = discriminant == 0;

            if (isDiscriminantZero) {
                calculateSingleRoot();
            } else if (isDiscriminantPositive) {
                calculateTwoRoots(discriminant);
            } else {
                System.out.println("The equation has no solutions!");
            }
        } else {
            System.out.println("'a' cannot be zero");
        }
    }

    private void calculateTwoRoots(double discriminant) {
        double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        System.out.print("The roots of equation " + equation + ":\n1)" + x1 + "\n2)" + x2);
    }

    private void calculateSingleRoot() {
        double x = -b / 2 * a;
        System.out.println("Single root of equation " + equation + " - " + x);
    }

    public static void main(String[] args) {
        QuadraticEquation quadraticEquation = new QuadraticEquation(1, 2, 1);
        quadraticEquation.solveEquation();
    }
}

