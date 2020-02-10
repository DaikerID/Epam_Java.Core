package com.Epam.JavaCore.hw20_07_02_20.carrier.domain;


import java.sql.ResultSet;

public class CarrierMapper {
    public static Carrier mapCarrier(ResultSet rs) throws Exception{
        Carrier carrier = new Carrier();
        carrier.setId(rs.getLong("ID"));
        carrier.setName(rs.getString("NAME"));
        carrier.setAddress(rs.getString("ADDRESS"));
        carrier.setCarrierType(CarrierType.valueOf(rs.getString("ENTITY_TYPE")));
        return carrier;
    }
}
