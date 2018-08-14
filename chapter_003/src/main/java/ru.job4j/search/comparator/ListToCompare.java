package ru.job4j.search.comparator;

import java.util.Comparator;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ListToCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());
        int result = 0;
        for (int i = 0; i < min && result == 0; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}