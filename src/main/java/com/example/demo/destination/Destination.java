package com.example.demo.destination;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Destination {
    private int id;
    private String name;
    private String resources;

    public Destination(int id, String name, String resources) {
        this.id = id;
        this.name = name;
        this.resources = resources;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    static public Destination fillFromResultSet(ResultSet set) throws SQLException {
        return new Destination(set.getInt("id"), set.getString("name"), set.getString("resources"));
    }
}
