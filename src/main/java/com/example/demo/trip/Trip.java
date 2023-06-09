package com.example.demo.trip;

import org.hibernate.dialect.function.TruncFunction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Trip {
    private int id;
    private String emission;
    private String startpoint;
    private String stoppoints;
    private String endpoint;
    private String vehicleType;
    private double duration;
    private double distance;
    private double price;
    private int begintime;
    private int endtime;

    public Trip (int id, String emission, String startpoint, String stoppoints,
                 String endpoint, String vehicleType, double duration,
                 double distance, double price, int begintime, int endtime)
    {
        this.id = id;
        this.emission = emission;
        this.startpoint = startpoint;
        this.stoppoints = stoppoints;
        this.endpoint = endpoint;
        this.vehicleType = vehicleType;
        this.duration = duration;
        this.distance = distance;
        this.price = price;
        this.begintime = begintime;
        this.endtime = endtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmission() {
        return emission;
    }

    public void setEmission(String emission) {
        this.emission = emission;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public String getStoppoints() {
        return stoppoints;
    }

    public void setStoppoints(String stoppoints) {
        this.stoppoints = stoppoints;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setEndtime(int endtime) { this.endtime = endtime; }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getEndtime() { return endtime; }
    public int getBegintime() {
        return begintime;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBegintime(int begintime){
        this.begintime = begintime;
    }

    static public Trip fillFromResultSet(ResultSet set)throws SQLException{
        return new Trip(set.getInt("id"), set.getString("emission"),
                set.getString("startpoint"), set.getString("stoppoints"),
                set.getString("endpoint"), set.getString("vehicletype"),
                set.getDouble("duration"), set.getDouble("distance"), set.getDouble("price"),
                set.getInt("begintime"), set.getInt("endtime"));
    }
}
