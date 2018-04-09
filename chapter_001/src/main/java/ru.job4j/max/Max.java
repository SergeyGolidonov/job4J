package ru.job4j.max;

public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    public int maximum(int first, int second, int third) {
        return (max(first, max(second, third)));
    }
}
