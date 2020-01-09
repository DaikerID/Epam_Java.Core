package com.Epam.JavaCore.hw13_30_12_19.cargo.repo.impl;


import com.Epam.JavaCore.hw13_30_12_19.common.solutions.comparator.SimpleComparator;
import com.Epam.JavaCore.hw13_30_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw13_30_12_19.cargo.domain.CargoField;
import com.Epam.JavaCore.hw13_30_12_19.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw13_30_12_19.cargo.search.CargoSearchCondition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.Epam.JavaCore.hw13_30_12_19.cargo.domain.CargoField.NAME;
import static com.Epam.JavaCore.hw13_30_12_19.cargo.domain.CargoField.WEIGHT;

public abstract class CommonCargoRepo implements CargoRepo {

    private static final List<CargoField> FIELDS_ORDER_TO_SORT_CARGOS = Arrays.asList(NAME, WEIGHT);

    private static final Comparator<Cargo> CARGO_NAME_COMPARATOR = new Comparator<Cargo>() {
        @Override
        public int compare(Cargo o1, Cargo o2) {
            return SimpleComparator.STRING_COMPARATOR.compare(o1.getName(), o2.getName());
        }
    };

    private static final Comparator<Cargo> CARGO_WEIGHT_COMPARATOR = new Comparator<Cargo>() {
        @Override
        public int compare(Cargo o1, Cargo o2) {
            return Integer.compare(o1.getWeight(), o2.getWeight());
        }
    };

    protected Comparator<Cargo> createCargoComparator(CargoSearchCondition searchCondition) {
        Comparator<Cargo> result = null;
        //NAME, WEIGHT
        for (CargoField cargoField : FIELDS_ORDER_TO_SORT_CARGOS) {
            if (searchCondition.shouldSortByField(cargoField)) {

                if (result == null) {
                    result = getComparatorForCargoField(cargoField);
                } else {
                    result = result.thenComparing(getComparatorForCargoField(cargoField));
                }
            }
        }


        return result;
    }


    private Comparator<Cargo> getComparatorForCargoField(CargoField cargoField) {
        switch (cargoField) {

            case NAME: {
                return CARGO_NAME_COMPARATOR;
            }
            case WEIGHT: {
                return CARGO_WEIGHT_COMPARATOR;
            }
        }

        return null;
    }


}
