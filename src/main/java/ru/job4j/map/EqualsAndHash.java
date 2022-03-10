package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class EqualsAndHash {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar(1988, GregorianCalendar.AUGUST, 22);
        User user1 = new User("Oleg", 1, c);
        User user2 = new User("Oleg", 3, c);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map.entrySet());
        System.out.println(user1.equals(user2));
        System.out.println(map.get(user1).hashCode());
        System.out.println(map.get(user2).hashCode());
    }
}
