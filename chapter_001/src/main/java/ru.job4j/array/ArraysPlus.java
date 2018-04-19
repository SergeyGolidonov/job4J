package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */


public class ArraysPlus {
    public static int[] arraysPlus(int[] arrayA, int[] arrayB) {
        int[] answer = new int[arrayA.length + arrayB.length];
        int i = arrayA.length - 1, j = arrayB.length - 1, k = answer.length;

        while (k > 0)
            answer[--k] = (j < 0 || (i >= 0 && arrayA[i] >= arrayB[j])) ? arrayA[i--] : arrayB[j--];
        return answer;
    }
}