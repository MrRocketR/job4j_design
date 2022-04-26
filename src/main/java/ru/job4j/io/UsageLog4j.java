package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        float f = 2.3f;
        String s = "Hi";
        LOG.debug("Test debug is {},  and {} ", f, s);
        char c = 'C';
        int i = 42;
        double d = 5.5d;
        short sh = 2;
        long l = 20000000;
        boolean boo = true;
        byte someByte = 1;
        LOG.debug("All together log output {} and {} and {} and {} but then {} {} {} {} ", l, f,
                c, i, d, sh, boo, someByte);
    }
}