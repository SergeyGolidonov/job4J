package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayString {

    boolean contains(String origin, String sub) {
        char[] originChar = origin.toCharArray();
        char[] subChar = sub.toCharArray();

        boolean result = false;

        for(int i = 0; i < originChar.length; i++) {
            for(int j = 0; j <subChar.length; j++) {
                if(originChar[i] == subChar[j]) {
                    j++;
                }else{
                    j = 0;
                }
                if(j == subChar.length) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}