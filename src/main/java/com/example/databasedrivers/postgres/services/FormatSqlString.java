package com.example.databasedrivers.postgres.services;

public class FormatSqlString {
    public static String formatSqlString(String sql) {
        if (sql != null) {
            return sql.replaceAll("'", "''");
        } else {
            return null;
        }
    }
}
