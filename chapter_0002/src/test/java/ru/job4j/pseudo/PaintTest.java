package ru.job4j.pseudo;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    @Test
    public void testForSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия, пишущие в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                        .append("******\n")
                        .append("*    *\n")
                        .append("*    *\n")
                        .append("******\n")
                        .append(System.lineSeparator())
                        .toString()));
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);

    }

    @Test
    public void testForTriangle() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфер для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия, пишущие в консоль.
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                        .append("   *   \n")
                        .append("  ***  \n")
                        .append(" ***** \n")
                        .append("*******\n")
                        .append(System.lineSeparator())
                        .toString()));
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}