package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

        public static void main(String[] args) {
            LOG.trace("trace message");
            LOG.debug("debug message");
            LOG.info("info message");
            LOG.warn("warn message");
            LOG.error("error message");

            String name = "Nikita";
            int age = 99;
            byte weight = 70;
            short exp = 0;
            long salary = 1000000;
            float unKnow = 1.1f;
            double height = 1.72;
            char sex = 'm';
            boolean student = true;
            LOG.debug("user info name : {}, age : {}, weight : {}, exp : {}, salary : {}, unKnow : {}, height : {}, sex : {}, student : {}  ",
                    name, age, weight, exp, salary, unKnow, height, sex, student);
        }
}
