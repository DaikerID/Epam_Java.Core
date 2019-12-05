package com.Epam.JavaCore.hw_2_4_12_19;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    private String equation;

   public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        Solver.solve(new QuadraticEquation(1,2,1));
    }

    @Override
    public String toString() {
        return this.a + "x^2 + " + this.b + "x + " + this.c + " = 0";
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}

