package org.example;

public interface DatabaseOperations<T> {
    void save(T entity);
    void delete(T entity);
    T getById(int id);
}
