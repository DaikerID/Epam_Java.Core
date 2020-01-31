package com.Epam.JavaCore.hw18_29_01_20.common.business.service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public interface CommonService<TYPE, ID> {
    Optional<TYPE> findById(ID id);

    void save(TYPE entity);

    boolean update(TYPE entity);

    boolean deleteById(ID id);

    Optional<List<TYPE>> getAll();

    int countAll();

    void printAll();

    Optional<List<TYPE>> filterBy(Predicate<TYPE> condition);

    <U> Optional<List<TYPE>> filterBy(U param, BiPredicate<TYPE, U> condition);
}
