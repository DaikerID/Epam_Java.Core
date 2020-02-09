package com.Epam.JavaCore.hw20_07_02_20.common.business.domain;

import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.ClothersCargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.FoodCargo;
import com.Epam.JavaCore.hw20_07_02_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw20_07_02_20.carrier.domain.CarrierType;
import com.Epam.JavaCore.hw20_07_02_20.transportation.domain.Transportation;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;

import static com.Epam.JavaCore.hw20_07_02_20.common.solutions.comparator.SimpleComparator.LONG_COMPARATOR;
import static com.Epam.JavaCore.hw20_07_02_20.common.solutions.comparator.SimpleComparator.STRING_COMPARATOR;

public class EnityUtill {
    private EnityUtill() {
    }

    public static FoodCargo genFoodCargo(Random random) {
        FoodCargo foodCargo = new FoodCargo();
        foodCargo.setName(String.valueOf(random.nextInt()));
        foodCargo.setWeight(random.nextInt());
        foodCargo.setExpirationDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
        foodCargo.setStoreTemperature(random.nextInt());
        return foodCargo;
    }

    public static ClothersCargo genClothersCargo(Random random) {
        ClothersCargo clothersCargo = new ClothersCargo();
        clothersCargo.setName(String.valueOf(random.nextInt()));
        clothersCargo.setWeight(random.nextInt());
        clothersCargo.setMaterial(String.valueOf(random.nextInt()));
        clothersCargo.setSize(String.valueOf(random.nextLong()));
        return clothersCargo;
    }

    public static Carrier genCarrier(Random random) {
        Carrier carrier = new Carrier();
        carrier.setAddress(String.valueOf(random.nextInt()));
        carrier.setCarrierType(random.nextInt() % 2 == 0 ? CarrierType.CAR : CarrierType.PLANE);
        carrier.setName(String.valueOf(random.nextInt()));
        return carrier;
    }

    public static Transportation genTransportation(Random random) {
        Transportation transportation = new Transportation();
        transportation.setDescription(String.valueOf(random.nextInt()));
        transportation.setBillTo(String.valueOf(random.nextInt()));
        transportation.setTransportationBeginDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
        return transportation;
    }

    public static boolean areCargosEquals(Cargo cargo1, Cargo cargo2) {
        if (cargo1 == null && cargo2 == null) {
            return true;
        } else if (cargo1 != null && cargo2 == null) {
            return false;
        } else if (cargo1 == null) {
            return false;
        } else if (cargo1.getCargoType() == cargo2.getCargoType()) {
            switch (cargo1.getCargoType()) {
                case FOOD:
                    return areFoodCargosEquals((FoodCargo) cargo1, (FoodCargo) cargo2);
                case CLOTHERS:
                    return areClotherCargosEquals((ClothersCargo) cargo1, (ClothersCargo) cargo2);
            }
        }
        return false;
    }

    private static boolean areFoodCargosEquals(FoodCargo food1, FoodCargo food2) {
        return STRING_COMPARATOR.compare(food1.getName(), food2.getName()) == 0
                && LONG_COMPARATOR.compare(food1.getId(), food2.getId()) == 0
                && food1.getWeight() == food2.getWeight()
                && food1.getStoreTemperature() == food2.getStoreTemperature();
    }

    private static boolean areClotherCargosEquals(ClothersCargo clother1, ClothersCargo clother2) {
        return STRING_COMPARATOR.compare(clother1.getName(), clother2.getName()) == 0
                && LONG_COMPARATOR.compare(clother1.getId(), clother2.getId()) == 0
                && STRING_COMPARATOR.compare(clother1.getMaterial(), clother2.getMaterial()) == 0;
    }

    public static boolean areCargosEquals(List<? extends Cargo> cargos1, List<? extends Cargo> cargos2) {
        if (cargos1 == null && cargos2 == null) {
            return true;
        } else if (cargos1 != null && cargos2 == null) {
            return false;
        } else if (cargos1 == null) {
            return false;
        } else if (cargos1.size() != cargos2.size()) {
            return false;
        } else {
            for (int i = 0; i < cargos1.size(); i++) {
                if (!areCargosEquals(cargos1.get(i), cargos2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean areCarriersEquals(Carrier carrier1, Carrier carrier2) {
        if (carrier1 == null && carrier2 == null) {
            return true;
        } else if (carrier1 != null && carrier2 == null) {
            return false;
        } else if (carrier1 == null) {
            return false;
        } else {
            return STRING_COMPARATOR.compare(carrier1.getName(), carrier2.getName()) == 0
                    && LONG_COMPARATOR.compare(carrier1.getId(), carrier2.getId()) == 0
                    && STRING_COMPARATOR.compare(carrier1.getAddress(), carrier2.getAddress()) == 0
                    && carrier1.getCarrierType().equals(carrier2.getCarrierType());
        }
    }

    public static boolean areCarriersEquals(List<Carrier> carrier1, List<Carrier> carrier2) {
        if (carrier1 == null && carrier2 == null) {
            return true;
        } else if (carrier1 != null && carrier2 == null) {
            return false;
        } else if (carrier1 == null) {
            return false;
        } else if (carrier1.size() != carrier2.size()) {
            return false;
        } else {
            for (int i = 0; i < carrier1.size(); i++) {
                if (!areCarriersEquals(carrier1.get(i), carrier2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean areTransportationsEquals(Transportation transportation1, Transportation transportation2) {
        if (transportation1 == null && transportation2 == null) {
            return true;
        } else if (transportation1 != null && transportation2 == null) {
            return false;
        } else if (transportation1 == null) {
            return false;
        } else {
            return STRING_COMPARATOR.compare(transportation1.getDescription(), transportation2.getDescription()) == 0
                    && LONG_COMPARATOR.compare(transportation1.getId(), transportation1.getId()) == 0
                    && STRING_COMPARATOR.compare(transportation1.getBillTo(), transportation2.getBillTo()) == 0
                    && areCargosEquals(transportation1.getCargo(), transportation2.getCargo())
                    && areCarriersEquals(transportation1.getCarrier(), transportation2.getCarrier());
        }
    }

    public static boolean areTransportationEquals(List<Transportation> transportation1,
                                                  List<Transportation> transportation2) {
        if (transportation1 == null && transportation2 == null) {
            return true;
        } else if (transportation1 != null && transportation2 == null) {
            return false;
        } else if (transportation1 == null) {
            return false;
        } else if (transportation1.size() != transportation2.size()) {
            return false;
        } else {
            for (int i = 0; i < transportation1.size(); i++) {
                if (!areTransportationsEquals(transportation1.get(i), transportation2.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

}
