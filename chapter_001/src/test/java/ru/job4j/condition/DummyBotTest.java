package ru.job4j.condition;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

 /**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class DummyBotTest {

     @Test
     public void whenGreetBot() {
         DummyBot bot = new DummyBot();
         assertThat(
                 bot.answer("Привет, Бот."),
                 is("Привет, умник.")
         );
     }

     @Test
     public void whenByuBot() {
         DummyBot bot = new DummyBot();
         assertThat(
                 bot.answer("Пока."),
                 is("До скорой встречи.")
         );
     }

     @Test
     public void whenUnknownBot() {
         DummyBot bot = new DummyBot();
         assertThat(
                 bot.answer("Сколько будет 2 + 2?"),
                 is("Это ставит меня в тупик. Спросите другой вопрос.")
         );
     }
}