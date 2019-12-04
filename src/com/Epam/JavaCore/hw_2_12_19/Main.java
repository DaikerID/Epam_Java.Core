package com.Epam.JavaCore.hw_2_12_19;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        result(0, 0, 1);
    }

    public static void result(int a, int b, int c) {
        try {
            if (a != 0) {
                String equation = a + "x^2 + " + b + "x + " + c + " = 0 ";
                double disc = Math.pow(b, 2) - 4 * a * c;
                if (disc == 0) {
                    double x = -b / 2 * a;
                    System.out.println("Корень уравнения " + equation + " - " + x);
                } else if (disc > 0) {
                    double x1 = (-b + Math.sqrt(disc)) / (2 * a);
                    double x2 = (-b - Math.sqrt(disc)) / (2 * a);
                    System.out.print("Корни уравнения " + equation + ":\n1)" + x1 + "\n2)" + x2);
                } else {
                    System.out.println("Уравнение " + equation + " не имеет корней");
                }
            } else
                System.out.println("'а' не может быть равным нулю в квадратном уравнении!");
        } catch (ArithmeticException e) {
            System.out.println("Что-то не так");
        }
    }
}
