package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {

        int add = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                add += i;
            }
        }
        return add;
    }
}
