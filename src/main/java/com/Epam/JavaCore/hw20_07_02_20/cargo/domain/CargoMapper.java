package com.Epam.JavaCore.hw20_07_02_20.cargo.domain;

import com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.JavaUtilDateUtils;
import com.Epam.JavaCore.hw4_9_12_19.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CargoMapper {
    public static Cargo mapCargo(ResultSet rs) throws Exception {
        switch (CargoType.valueOf(rs.getString("ENTITY_TYPE"))){
            case FOOD:
                return mapFoodCargo(rs);
            case CLOTHERS:
                return mapClothersCargo(rs);
        }
        return null;
    }

    private static FoodCargo mapFoodCargo(ResultSet rs) throws Exception {
        FoodCargo foodCargo = new FoodCargo();
        foodCargo.setId(rs.getLong("ID"));
        foodCargo.setName(rs.getString("NAME"));
        foodCargo.setWeight(rs.getInt("WEIGHT"));
        foodCargo.setExpirationDate(JavaUtilDateUtils.valueOf(rs.getString("FOOD_EXPIRATION_DATE")));
        foodCargo.setStoreTemperature(rs.getInt("FOOD_STORE_TEMPERATURE"));
        return foodCargo;
    }

    private static ClothersCargo mapClothersCargo(ResultSet rs) throws Exception {
        ClothersCargo clothersCargo = new ClothersCargo();
        clothersCargo.setId(rs.getLong("ID"));
        clothersCargo.setName(rs.getString("NAME"));
        clothersCargo.setWeight(rs.getInt("WEIGHT"));
        clothersCargo.setMaterial(rs.getString("CLOTHERS_MATERIAL"));
        clothersCargo.setSize(rs.getString("CLOTHERS_SIZE"));
        return clothersCargo;
    }
}
