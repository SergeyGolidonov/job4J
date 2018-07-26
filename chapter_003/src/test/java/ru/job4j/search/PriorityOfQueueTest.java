package ru.job4j.search;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityOfQueueTest {
    @Test
    public void mostHigherPriority() {
        PriorityOfQueue queue = new PriorityOfQueue();
        queue.put(new Task("low", 7));
        queue.put(new Task("needed", 1));
        queue.put(new Task("inTheMiddle", 4));
        Task result = queue.take();
        assertThat(result.getDesc(), is("needed"));
    }
}