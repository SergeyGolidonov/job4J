package ru.job4j.pseudo;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Paint {

    public void draw(Shape shape) { // Реализация метода draw с параметрами интерфейса Shape
        System.out.println(shape.draw()); // Вывод метода на экран
    }

    public static void main(String[] args) {
        Shape triagle = new Triangle(); // Создание объекта "Треугольник"
        Shape square = new Square(); // Создание объекта "Квадрат"
        Paint paint = new Paint(); // Создание объекта Paint
        System.out.println("Triagle: "); // Печать Треугольника
        paint.draw(triagle); // Вызов метода draw на треугольнике
        System.out.println("Square: "); // Печать Квадрата
        paint.draw(square); // Вызов метода draw на квадрате
    }
}