package com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.db.utils;

public interface JdbcConsumer<T> {
    void accept(T t) throws Exception;
}
