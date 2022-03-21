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
        System.out.println(result.getChanged());
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
        Map<Integer, String> list = new HashMap<>();
        for (User user : previous) {
            list.put(user.getId(), user.getName());
        }
        for (User user : current) {
            String temp = list.get(user.getId());
            if (temp != null && !temp.equals(user.getName())) {
                out++;
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
        for (User user : userSet) {
            int id = user.getId();
            idList.add(id);
        }
        return idList;
    }
}
