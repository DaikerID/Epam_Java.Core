package com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.db.utils;

import java.sql.Connection;

public class CustomConnectionPool {
    private static final CustomConnectionPool INSTANCE = new CustomConnectionPool();

    public Connection getConnection(){
        return null;
    }

    public static CustomConnectionPool getInstance() {
        return INSTANCE;
    }
}
