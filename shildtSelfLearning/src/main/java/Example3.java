
/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Example3 {
    public static void main(String[] args) {
        int var = 10; // Содержит целочисленные переменные
        double x = 10.0; // Содержит переменные с плавающей точкой

        System.out.println("Начальное значение переменной var: " + var);
        System.out.println("Начальное значение переменной x: " + x);

        // Разделим каждую меременную на 4
        var = var / 4;
        x = x / 4;

        System.out.println("Теперь переменная var равна: " + var);
        System.out.println("Теперь переменная x равна: " + x);
    }
}