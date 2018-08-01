package ru.job4j.search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for(int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}