package com.example.databasedrivers;

import java.util.Collection;
import java.util.List;

public interface DescriptionDao<T, I> {
    T get(I id) throws DuplicatePrimaryKeyException;

    Collection<T> getAll();

    int save(T t);

    Long saveReturnID(T t);

    List<T> getByName(String name);

    int update(T t);

    int delete(T t);
}