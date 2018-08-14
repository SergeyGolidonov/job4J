package ru.job4j.search.listtomap;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {
    @Test
    public void whenListConvertToMap() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(12, "John", "NY"));
        list.add(new User(11, "Bill", "Miami"));
        list.add(new User(75, "Ilon Mask", "California"));
        Map<Integer, User> result = userConvert.process(list);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(12, new User(12, "John", "NY"));
        expected.put(11, new User(11, "Bill", "Miami"));
        expected.put(75, new User(75, "Ilon Mask", "California"));
        assertThat(result, is(expected));
    }
}