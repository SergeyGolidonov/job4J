package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayString {

    boolean contains(String origin, String sub) {
        char[] originChar = origin.toCharArray(); // Преобразовали строку в массив
        char[] subChar = sub.toCharArray(); // Преобразовали строку в массив
        boolean result = false;
        int in = 0; // Счетчик начинается с 0
        for(int i = 0; i < originChar.length; i++) { // Проходим по длинне массива
            if (originChar[in] == subChar[in]) { // Сравниваем значения в массивах
                in++; // Если услови верно, проходим по массиву дальше
            } else { //
                in = 0; // Если услови не верно, заканчиваем итерацию
            }
            if (in == subChar.length) { // сравниваем результат счетчика с массивом
                result = true; // Если результат счетика совпал с массивом - условие верно
                break; // Выходим из цикла
            }
        }
        return result;
    }
}