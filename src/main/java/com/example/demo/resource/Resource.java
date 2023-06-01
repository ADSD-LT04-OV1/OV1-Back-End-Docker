package com.example.demo.resource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Resource {
    private int id;
    private String type;

    public Resource(int id, String type) {
        this.id = id;
        this.type = type;
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

    static public Resource fillFromResultSet(ResultSet set ) throws SQLException{
        return new Resource(set.getInt("id"), set.getString("type"));
    }
}
