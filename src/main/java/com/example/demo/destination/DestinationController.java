package com.example.demo.destination;

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
@RequestMapping("/api/v1/destination")
public class DestinationController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public ArrayList<Destination> getAll() throws SQLException {
        ArrayList<Destination> destinations = new ArrayList<>();

        Statement statement = this.jdbcTemplate.getDataSource().getConnection().createStatement();
        ResultSet set = statement.executeQuery("select * from destination");
        while (set.next()) {
           destinations.add(Destination.fillFromResultSet(set));
        }
        set.close();
        statement.close();
        return destinations;
    }

    @GetMapping(path = "/{id}")
    public ArrayList<Destination> findById(@PathVariable("id") final int id){
        final ArrayList<Destination> destinations = new ArrayList<>();
        try{
            PreparedStatement statement = this.jdbcTemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM destination WHERE id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                destinations.add(Destination.fillFromResultSet(set));
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return destinations;
    }
}
