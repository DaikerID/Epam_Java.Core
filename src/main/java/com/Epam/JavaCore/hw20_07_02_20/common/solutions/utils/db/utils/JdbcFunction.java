package com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.db.utils;

public interface JdbcFunction<FROM, TO> {
    TO apply(FROM from) throws Exception;
}
