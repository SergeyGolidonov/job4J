package ru.job4j;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public class Func {
    public List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index <= end; index++) {
            result.add(function.apply((double) index));
        }
        return result;
    }
}