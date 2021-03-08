package ru.job4j.exam;

import org.junit.Test;
import ru.job4j.exam.*;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MailTest {

    @Test
    public void whenThen() {
    Set<Mail.User> set = new HashSet<>();
        Mail.User user1 = new Mail.User("user1", new HashSet<>(Set.of(("xxx@ya.ru"), ("foo@gmail.com"),
                ("lol@mail.ru"))));
        Mail.User user2 = new Mail.User("user2", new HashSet<>(Set.of(("ups@pisem.net"),
                ("foo@gmail.com"))));
        Mail.User user4 = new Mail.User("user4", new HashSet<>(Set.of(("aaa@bbb.ru"),
                ("ups@pisem.net"))));

        Mail.User user3 = new Mail.User("user3", new HashSet<>(Set.of(("xyz@pisem.net"),
                ("vasya@pupkin.com"))));
        Mail.User user5 = new Mail.User("user5", new HashSet<>(Set.of(
                ("xyz@pisem.net"))));
        set.add(user1);
        set.add(user2);
        set.add(user3);
        set.add(user4);
        set.add(user5);
        Mail mail = new Mail();
        Map<String, Set<String>> expected = new HashMap<>();
        expected.put("user4", new HashSet<>(Set.of(("xxx@ya.ru"),
                ("foo@gmail.com"), ("ups@pisem.net"), ("aaa@bbb.ru"),
                ("lol@mail.ru"))));
        expected.put("user5", new HashSet<>(Set.of(("vasya@pupkin.com"),
                ("xyz@pisem.net"))));
        Map<String, Set<String>> actual = mail.insert(set);

        assertThat(actual, is(expected));

    }

//        mail.process(set);
//        Set<Mail.User> actual = mail.setUsers;

//        Set<Mail.User> exp = new HashSet<>();
//        exp.add(new Mail.User("user1", new HashSet<>(Set.of(("xxx@ya.ru"),
//                ("foo@gmail.com"),
//                ("lol@mail.ru")))));
//        exp.add(new Mail.User("user5", new HashSet<>(Set.of(
//                ("vasya@pupkin.com"),
//                ("xyz@pisem.net")))));








//    @Test
//    public void whenThen() {
//        Set<Mail.User> set = new HashSet<>();
//        set.add(new Mail.User("user1", new HashSet<>(Set.of(("xxx@ya.ru"), ("foo@gmail.com"),
//                ("lol@mail.ru")))));
//        set.add(new Mail.User("user3", new HashSet<>(Set.of(
//                ("xyz@pisem.net"),
//                ("vasya@pupkin.com")))));
//        set.add(new Mail.User("user5", new HashSet<>(Set.of(
//                ("xyz@pisem.net")))));
//        set = new Mail().process(set);
//
//        Set<Mail.User> exp = new HashSet<>();
//        exp.add(new Mail.User("user1", new HashSet<>(Set.of(("xxx@ya.ru"),
//                ("foo@gmail.com"),
//                ("lol@mail.ru")))));
//        exp.add(new Mail.User("user5", new HashSet<>(Set.of(
//                ("vasya@pupkin.com"),
//                ("xyz@pisem.net")))));
//        assertEquals(exp, set);
//
//    }

//    @Test
//    public void whenThen() {
//        Mail mail = new Mail();
//        Map<Mail.User, Set <Mail.Email>> map = new HashMap<>();
//        map.put(new Mail.User("user1"), Set.of(
//                new Mail.Email("xxx@ya.ru"),
//                new Mail.Email("foo@gmail.com"),
//                new Mail.Email("lol@mail.ru")));
//        map.put(new Mail.User("user2"), Set.of(
//                new Mail.Email("foo@gmail.com"),
//                new Mail.Email("ups@pisem.net")));
//        map.put(new Mail.User("user3"), Set.of(
//                new Mail.Email("xyz@pisem.net"),
//                new Mail.Email("vasya@pupkin.com")));
//        map.put(new Mail.User("user4"), Set.of(
//                new Mail.Email("ups@pisem.net"),
//                new Mail.Email("aaa@bbb.ru")));
//        map.put(new Mail.User("user5"), Set.of(
//                new Mail.Email("xyz@pisem.net")));
//
//
//
//        Map<Mail.User, Set<Mail.Email>> exp = new HashMap<>();
//        exp.put(new Mail.User("user1"), Set.of(
//                    new Mail.Email("xxx@ya.ru"),
//                    new Mail.Email("foo@gmail.com"),
//                    new Mail.Email("lol@mail.ru"),
//                    new Mail.Email("ups@pisem.net"),
//                    new Mail.Email("aaa@bbb.ru")));
//        exp.put(new Mail.User("user3"), Set.of(
//                        new Mail.Email("xyz@pisem.net"),
//                        new Mail.Email("vasya@pupkin.com")));
//         Map<Mail.User, Set<Mail.Email>> actual = new HashMap<>(mail.unitMail(map));
//         assertEquals(exp, actual);
//
//    }

}