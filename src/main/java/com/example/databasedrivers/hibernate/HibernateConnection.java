package com.example.databasedrivers.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateConnection {
    private static SessionFactory hibernateSessionFactory = null;
    private static Session hibernateSession = null;

    private HibernateConnection() {
    }

    public static Session getHibernateSession() {
        if (hibernateSessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try {
                hibernateSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(registry);
                throw e;
            }
        }
        if (hibernateSession == null || !hibernateSession.isOpen()) {
            hibernateSession = hibernateSessionFactory.openSession();
        }
        return hibernateSession;
    }


    public static <R> R runInHibernateSession(FeedMeLambdasIllInferTheReturnType<R> feedMeLambdasIllInferTheReturnType) {
        getHibernateSession().beginTransaction();
        R result = feedMeLambdasIllInferTheReturnType.op();
        getHibernateSession().getTransaction().commit();
        getHibernateSession().close();
        return result;
    }
}
