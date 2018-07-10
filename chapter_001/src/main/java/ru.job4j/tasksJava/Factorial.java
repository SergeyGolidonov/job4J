package ru.job4j.tasksJava;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Factorial {
    // Рекурсивный метод
    int factR(int n) {
        int result;

        if(n==1)
            return 1;
        // Рекурсивный вызов метода factRO
        result = factR(n - 1) * n;
        return result;
    }
    // Вариант программы, вычисляющей факториал итеративным способом
    int fact1(int n) {
        int t, result;

        result = 1;

        for(t = 1; t <= n; t++)
        result *= t;
        return result;
    }
}

class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println("Factorial using recursive method.");

        System.out.println("Factorial of 1 is " + f.factR(1));
        System.out.println("Factorial of 3 is " + f.factR(3));
        System.out.println("Factorial of 4 is " + f.factR(4));
        System.out.println("Factorial of 7 is " + f.factR(7));
        System.out.println();

        System.out.println("Factorial using iterative method.");

        System.out.println("Factorial of 0 is " + f.fact1(0));
        System.out.println("Factorial of 1 is " + f.fact1(1));
        System.out.println("Factorial of 2 is " + f.fact1(2));
        System.out.println("Factorial of 3 is " + f.fact1(3));
        System.out.println("Factorial of 5 is " + f.fact1(5));
        System.out.println("Factorial of 9 is " + f.fact1(9));
    }
}