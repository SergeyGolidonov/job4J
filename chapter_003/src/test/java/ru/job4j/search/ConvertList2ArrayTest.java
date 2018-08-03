package ru.job4j.search;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9When3Rows() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when3ElementsThen9When3Rows() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3), 3);
        int[][] expect = {
                {1, 2, 3},
                {0, 0, 0},
                {0, 0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when5ElementsThen16When4Rows() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5), 4);
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when5ElementsThen8When2Rows() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5), 2);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when2ArraysConvertIn1() {
        ConvertList2Array array = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = array.convert(list);
        List<Integer> exepted = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(exepted));
    }

    @Test
    public void when3ArraysConvertIn1() {
        ConvertList2Array array = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        list.add(new int[]{3, 6});
        List<Integer> result = array.convert(list);
        List<Integer> exepted = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 6);
        assertThat(result, is(exepted));
    }
}