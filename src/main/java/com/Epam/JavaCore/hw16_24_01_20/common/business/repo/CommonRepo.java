package com.Epam.JavaCore.hw16_24_01_20.common.business.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public interface CommonRepo<TYPE, ID> {

    TYPE findById(ID id);

    void save(TYPE entity);

    boolean update(TYPE entity);

    boolean deleteById(ID id);

    List<TYPE> getAll();

    int countAll();

    default List<TYPE> filterByOneCondition(Predicate<TYPE> condition) {
        List<TYPE> data = getAll();
        List<TYPE> result = new ArrayList<>();
        for (TYPE type : data) {
            if (type != null && condition.test(type)) {
                result.add(type);
            }
        }
        return result;
    }

    default <U> List<TYPE> filterByTwoConditions(U param, BiPredicate<TYPE, U> condition) {
        List<TYPE> data = getAll();
        List<TYPE> result = new ArrayList<>();
        for (TYPE type : data) {
            if (type != null && condition.test(type, param)) {
                result.add(type);
            }
        }
        return result;
    }
}
