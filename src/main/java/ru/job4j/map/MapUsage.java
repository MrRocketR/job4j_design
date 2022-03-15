package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapUsage {

    public static void main(String[] args) {
        Calendar c = new GregorianCalendar(1990, Calendar.APRIL, 21);
        String s = "Ivan";
        int i = 2;
        User user1 = new User(s, i, c);
        User user2 = new User(s, i, c);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(map.entrySet());
    }
}
