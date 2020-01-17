package com.Epam.JavaCore.hw3_6_12_19;

public class Route {
    private String departurePoint;
    private String arrivalPoint;
    private Float distance;  //TODO distance calculation

    public Route(String departurePoint, String arrivalPoint) {
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;

    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public Float getDistance() {
        return distance;
    }
}
