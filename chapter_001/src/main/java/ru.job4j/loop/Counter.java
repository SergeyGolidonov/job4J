package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {

        int add = 0;
        for (int i=1; i<=10; i++) {
            if (i%2==0) {
                add += i;
                System.out.println(add);
            }
        }
        return add;
    }
}
