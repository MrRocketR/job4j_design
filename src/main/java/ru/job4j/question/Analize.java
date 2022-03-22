package ru.job4j.question;

import java.util.*;

public class Analize {


    public static Info diff(Set<User> previous, Set<User> current) {
       int added = 0;
       int changed = 0;
       int deleted = 0;
       int keysCount = 0;
        Map<Integer, String> list = new HashMap<>();
        for (User user : previous) {
            list.put(user.getId(), user.getName());
        }
        for (User user : current) {
            String temp = list.get(user.getId());
            if (temp == null) {
                added++;
            }
            if (temp != null && !temp.equals(user.getName())) {
                changed++;
            }
            if (list.containsKey(user.getId())) {
                keysCount++;
            }
        }
        deleted = previous.size() - keysCount;
        return new Info(added, changed, deleted);
    }

}
