package ru.job4j.coffe;

import java.util.ArrayList;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class CoffeMachine {

    // Машина должна иметь какие то деньги на сдачу
    // Машина должна принимать деньги от клиентов
    // Машина должна правильно давать сдачу

    int[] changes(int value, int price) {
        int[] naminal = {1, 2, 5, 10};
        int position = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int delivery = value - price;
        int index = naminal.length - 1;
        while (delivery > 0) {
            while (delivery >= naminal[index]) {
                list.add(naminal[index]);
                delivery -= naminal[index];
                position++;
            }
            index--;
        }
        int[] result = new int[position];
        for (int i = 0; i < position; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}