package ru.job4j.pseudo;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Triangle implements Shape {

    public String draw() { // Использование метода из интерфейса
        StringBuilder picture = new StringBuilder(); // Создаем объект
        picture.append("   *   \n"); // Рисуем верхнюю точку треугольника, вызвав метод append. \n - перенос строки
        picture.append("  ***  \n"); // Рисуем треугольник далее, вызвав метод append. \n - перенос строки
        picture.append(" ***** \n"); // Рисуем треугольник далее, вызвав метод append. \n - перенос строки
        picture.append("*******\n"); // Рисуем нижнюю линию треугольника, вызвав метод append. \n - перенос строки
        return picture.toString(); // Возвращаем параметры picture, т.к. метод должен возвращать значение
    }
}