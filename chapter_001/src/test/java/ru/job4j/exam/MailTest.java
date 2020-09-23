package ru.job4j.exam;

import org.junit.Test;
import ru.job4j.exam.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MailTest {

    @Test
    public void whenThen() {
        Mail mail = new Mail();
        Map<Mail.Email, Mail.User> map = new HashMap<>();
        map.put(new Mail.Email("xxx@ya.ru"), new Mail.User("user1"));
        map.put(new Mail.Email("foo@gmail.com"), new Mail.User("user1"));
        map.put(new Mail.Email("lol@mail.ru"), new Mail.User("user1"));
        map.put(new Mail.Email("foo@gmail.com"), new Mail.User("user2"));
        map.put(new Mail.Email("ups@pisem.net"), new Mail.User("user2"));
        map.put(new Mail.Email("xyz@pisem.net"), new Mail.User("user3"));
        map.put(new Mail.Email("vasya@pupkin.com"), new Mail.User("user3"));
        map.put(new Mail.Email("ups@pisem.net"), new Mail.User("user4"));
        map.put(new Mail.Email("aaa@bbb.ru"), new Mail.User("user4"));
        map.put(new Mail.Email("xyz@pisem.net"), new Mail.User("user5"));

        Map<Mail.User, Set<Mail.Email>> exp = new HashMap<>();
        exp.put(new Mail.User("user1"), Set.of(
                    new Mail.Email("xxx@ya.ru"),
                    new Mail.Email("foo@gmail.com"),
                    new Mail.Email("lol@mail.ru"),
                    new Mail.Email("ups@pisem.net"),
                    new Mail.Email("aaa@bbb.ru")));
        exp.put(new Mail.User("user3"), Set.of(
                        new Mail.Email("xyz@pisem.net"),
                        new Mail.Email("vasya@pupkin.com")
                ));


//
//        map.put(, );
//        map.put(, new Mail.User("user1"));
//        map.put(, new Mail.User("user1"));
//        map.put(, new Mail.User("user1"));
//        map.put(, );
//        map.put(, new Mail.User("user3"));
         Map<Mail.User, Set<Mail.Email>> actual = new HashMap<>(mail.unitMail(map));
         assertEquals(exp, actual);

    }

}