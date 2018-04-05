package ru.job4j.calculator;

public class Converter {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @param value2 евро.
     * @return Евро.
     */
    public int rubleToEuro(int value, int value2) {
        int result = value / value2;
        return result;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @param value2 доллары.
     * @return Доллоры
     */
    public int rubleToDollar(int value, int value2) {
        int result = value / value2;
        return result;
    }
}
