package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayString {

    boolean contains(String origin, String sub) {
        String[] line = sub.split("");

        for(int i = 0; i < line.length; i++)
            if(origin.equals(line[i]))
                return true;

        return false;
    }
}