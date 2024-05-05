package com.example.databasedrivers.hibernate;

import com.example.model.ID;
import org.hibernate.query.Query;

import java.util.List;

import static com.example.databasedrivers.hibernate.HibernateConnection.getHibernateSession;
import static com.example.databasedrivers.hibernate.HibernateConnection.runInHibernateSession;

public class HibernateConnectionGenericMethods {
    private HibernateConnectionGenericMethods() {
    }

    private static <T extends ID> String genericGetTableNameFromClass(Class<T> classOfObject) {
        String[] packageLocation = classOfObject.getName().split("\\.");
        return packageLocation[packageLocation.length - 1];
    }

    public static <T> void genericSave(T obj) {
        runInHibernateSession(() -> {
            getHibernateSession().persist(obj);
            return null;
        });
    }

    public static <T extends ID> Long genericSaveReturnID(T obj) {
        runInHibernateSession(() -> {
            getHibernateSession().persist(obj);
            return null;
        });
        return obj.getId();
    }

    public static <T> T genericGet(Class<T> classOfObj, Long id) {
        return runInHibernateSession(() -> getHibernateSession().get(classOfObj, id));
    }

    public static <T extends ID> List<T> genericGetByName(Class<T> classOfObject, String name) {
        return runInHibernateSession(() -> {
            Query<T> tQuery = getHibernateSession().createQuery(
                    "from " + genericGetTableNameFromClass(classOfObject) + " c where c.name = '" + name + "'", classOfObject);

            return tQuery.getResultList();
        });
    }

    public static <T extends ID> void genericUpdate(T obj) {
        runInHibernateSession(() -> {
            getHibernateSession().merge(obj);
            return null;
        });
    }

    public static <T extends ID> void genericDelete(T obj) {
        runInHibernateSession(() -> {
            getHibernateSession().remove(obj);
            return null;
        });
    }

    public static <T extends ID> List<T> genericGetAll(Class<T> classOfObject) {
        return runInHibernateSession(() -> {
            Query<T> tQuery = getHibernateSession().createQuery(
                    "from " + genericGetTableNameFromClass(classOfObject), classOfObject);

            return tQuery.getResultList();
        });
    }
}
