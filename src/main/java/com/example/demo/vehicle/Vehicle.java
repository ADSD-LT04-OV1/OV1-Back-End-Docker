package com.example.demo.vehicle;

import com.example.demo.resource.Resource;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Vehicle {
    private int id;
    private String type;
    private String resource;
    private double emission;

    public Vehicle(int id, String type, String resource, double emission){
        this.id = id;
        this.type = type;
        this.resource = resource;
        this.emission = emission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public double getEmission() {
        return emission;
    }

    public void setEmission(double emission) {
        this.emission = emission;
    }

    static public Vehicle fillFromResultSet(ResultSet set ) throws SQLException{
        return new Vehicle(set.getInt("id"), set.getString("type"),
                set.getString("resource"), set.getDouble("emission"));
    }
}
