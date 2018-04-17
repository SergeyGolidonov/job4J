package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayString {

    boolean contains(String origin, String sub) {
        char[] or = origin.toCharArray();
        char[] su = sub.toCharArray();

        for(int i = 0; i < or.length; i++) {
            if(or[i] == su[i]) {
                i++;
            }else{
                i = 0;
            }
            if(i == sub.length()) {
                boolean result = true;
                break;
            }
        }
        return false;
    }
}