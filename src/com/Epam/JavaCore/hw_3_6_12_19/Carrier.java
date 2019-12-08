package com.Epam.JavaCore.hw_3_6_12_19;

import java.util.Vector;

public class Carrier {
    private Vector<Transportation> transportations;
    private Vector<DeliveryRoute> deliveryRoutes;

    public void addTransportation(Transportation transportation) {
        transportations.add(transportation);
    }

    public DeliveryRoute isPossibleToDeliverChippy(Cargo cargo) {
        //TODO do Dijkstra's algorithm
        return null;
    }

    public DeliveryRoute isPossibleToDeliverFaster(Cargo cargo) {
        //TODO do wide search
        return null;
    }

    public void addDeliveryRoute(DeliveryRoute deliveryRoute) {
        deliveryRoute.confirm();
        deliveryRoutes.add(deliveryRoute);
    }

}
