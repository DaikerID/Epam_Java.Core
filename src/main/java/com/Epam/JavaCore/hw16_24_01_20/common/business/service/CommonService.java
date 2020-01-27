package com.Epam.JavaCore.hw16_24_01_20.common.business.service;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public interface CommonService<TYPE, ID> {
    TYPE findById(ID id);

    void save(TYPE entity);

    boolean update(TYPE entity);

    boolean deleteById(ID id);

    List<TYPE> getAll();

    int countAll();

    void printAll();

    List<TYPE> filterBy(Predicate<TYPE> condition);

    <U> List<TYPE> filterBy(U param, BiPredicate<TYPE, U> condition);
}
