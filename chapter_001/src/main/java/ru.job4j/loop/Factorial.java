package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = n;
        for (int i = 1; i < 5; i++) {
            result *=i;
            System.out.println(result);
            if (n == 0) {
                return 1;
            }
        }
        return result;
    }
}
