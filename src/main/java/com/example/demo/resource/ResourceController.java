package com.example.demo.resource;

import com.example.demo.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/resource")

public class ResourceController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public ArrayList<Resource> getAll() throws SQLException {
        ArrayList<Resource> resources = new ArrayList<>();

        Statement statement = this.jdbcTemplate.getDataSource().getConnection().createStatement();
        ResultSet set = statement.executeQuery("select * from resource");
        while (set.next()){
            resources.add(Resource.fillFromResultSet(set));
        }
        set.close();
        statement.close();
        return resources;
    }

    @GetMapping(path = "/{id}")
    public ArrayList<Resource> findById(@PathVariable("id") final int id) {
        final ArrayList<Resource> resources = new ArrayList<>();
        try {
            PreparedStatement statement = this.jdbcTemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM resource WHERE id = ? ");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                resources.add(Resource.fillFromResultSet(set));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resources;
    }
}
