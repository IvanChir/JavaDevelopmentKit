package org.example;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase<T> implements DatabaseOperations<T> {
    private Map<Integer, T> database = new HashMap<>();
    private int currentId = 0;

    @Override
    public void save(T entity) {
        database.put(currentId++, entity);
        System.out.println("Saved: " + entity);
    }

    @Override
    public void delete(T entity) {
        database.values().remove(entity);
        System.out.println("Deleted: " + entity);
    }

    @Override
    public T getById(int id) {
        return database.get(id);
    }
}