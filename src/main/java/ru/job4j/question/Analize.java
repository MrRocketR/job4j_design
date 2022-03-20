package ru.job4j.question;

import java.util.*;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info result =  new Info(0, 0, 0);
        int added = Analize.added(previous, current);
        int changed = Analize.changed(previous, current);
        int deleted = Analize.deleted(previous, current);
        result.setAdded(added);
        result.setChanged(changed);
        result.setDeleted(deleted);
        return result;

    }

    private static int added(Set<User> previous, Set<User> current) {
       int out = 0;
        ArrayList<Integer> idList = getIdList(previous);
        for (User user : current) {
            if (!idList.contains(user.getId())) {
                out++;
            }
       }
           return out;
    }
    private static int changed(Set<User> previous, Set<User> current) {
        int out = 0;
        for (User user: previous) {
            Iterator<User> iterator = current.iterator();
            while (iterator.hasNext()) {
                int id = user.getId();
                String name = user.getName();
                User newUser = iterator.next();
                int newUserId = newUser.getId();
                String newUserName = newUser.getName();
                if (id == newUserId && !name.equals(newUserName)) {
                    out++;
                }
            }
        }
        return out;
    }
    private static int deleted(Set<User> previous, Set<User> current)  {
        int out = 0;
        ArrayList<Integer> idList = getIdList(current);
        for (User user : previous) {
            if (!idList.contains(user.getId())) {
                out++;
            }
        }
        return out;
    }

    private static ArrayList<Integer> getIdList(Set<User> userSet) {
        ArrayList<Integer> idList = new ArrayList<>();
        Iterator<User> iterator = userSet.iterator();
        while (iterator.hasNext()) {
            int prev = iterator.next().getId();
            idList.add(prev);
        }
        return idList;
    }
}
