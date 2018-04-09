package ru.job4j.loop;

public class Counter {
    public int add(int start, int finish) {

        int a = 0;
        for (int i=0; i<=10; i++) {
            if (i%2==0) {
                System.out.println(a*(a+1));
                a++;
            }
        }
        return a;
    }
}
