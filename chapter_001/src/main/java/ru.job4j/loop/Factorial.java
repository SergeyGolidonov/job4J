package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <6; i++) {
            result *=i;
            System.out.println(result);
        }
        return result;
    }
}
