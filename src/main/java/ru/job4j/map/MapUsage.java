package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapUsage {

    public static void main(String[] args) {
        Calendar c = new GregorianCalendar(1990, 12, 21);
        User user1 = new User("Ivan", 2, c);
        User user2 = new User("Ivan", 2, c);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map.entrySet());
        System.out.println(user1.equals(user2));
    }
}
