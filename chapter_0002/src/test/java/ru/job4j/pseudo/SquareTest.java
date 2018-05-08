package ru.job4j.pseudo;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SquareTest {
    @Test()
    public void testForSquere() {
        Square square = new Square(); // Создали объект квадрата для тестирования
        assertThat(square.draw(),
                is(new StringBuilder()
                        .append("******\n")
                        .append("*    *\n")
                        .append("*    *\n")
                        .append("******\n")
                        .toString()));
    }
}