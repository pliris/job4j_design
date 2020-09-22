package ru.job4j.exam;

import org.junit.Test;
import ru.job4j.exam.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MailTest {

    @Test
    public void whenThen() {
        Mail mail = new Mail();
        Map<Mail.Email, Mail.User> map = new HashMap<>();
        map.put(new Mail.Email("xxx@ya.ru"), user1);



                "foo@gmail.com", "user1",
                "lol@mail.ru", "user1",
                "foo@gmail.com", "user2",
                "ups@pisem.net", "user2",
                "xyz@pisem.net", "user3",
                "vasya@pupkin.com", "user3",
                "ups@pisem.net" , "user4",
                "aaa@bbb.ru", "user4",
                "xyz@pisem.net", "user5");
    }

}