package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class RoleStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();
    @Override
    public void add(T model) {
        storage.putIfAbsent(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean r = false;
        if (storage.containsKey(id)) {
            storage.replace(id, model);
            r = true;
        }
        return r;
    }

    @Override
    public boolean delete(String id) {
        boolean r = false;
        if (storage.containsKey(id)) {
            storage.remove(id);
            r = true;
        }
        return r;
    }

    @Override
    public T findById(String id) {
        return storage.getOrDefault(id, null);
    }
}
