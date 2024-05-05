package com.example.servlets.ServerConfiguration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static com.example.databasedrivers.postgres.datasource.PostgresDataSource.setDataSource;
import static com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.SingletonLogic.getPool;

//This is really fragile, moving up in tomcat version breaks it,
// and I do not think it really works in the ci/cd pipeline
@WebListener
public class StartStopListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("CONTEXT INITIALIZER: Initializing.");
        setDataSource("datasource-production");
        getPool();
        System.out.println("CONTEXT INITIALIZER: Finished Initializing");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("CONTEXT INITIALIZER: Servlet has been stopped");
    }
}