package com.example.demo.trip;

import com.example.demo.destination.Destination;
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
@RequestMapping("api/v1/trips")
public class TripController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public ArrayList<Trip> getAll() throws SQLException {
        ArrayList<Trip> trips = new ArrayList<>();

        Statement statement = this.jdbcTemplate.getDataSource().getConnection().createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM trip");
        while (set.next()) {
            trips.add(Trip.fillFromResultSet(set));
        }
        statement.close();
        set.close();
        return trips;
    }

    @GetMapping(path = "/{id}")
    public ArrayList<Trip> findById(@PathVariable("id") final int id) {
        final ArrayList<Trip> trips = new ArrayList<>();
        try {
            PreparedStatement statement = this.jdbcTemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM trip WHERE id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                trips.add(Trip.fillFromResultSet(set));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trips;
    }

    @GetMapping(path = "/{startpoint}/{endpoint}")
    public ArrayList<Trip> findByStartpoint(@PathVariable("startpoint") final String startpoint, @PathVariable("endpoint") final String endpoint) {
        final ArrayList<Trip> trips = new ArrayList<>();
        try {
            PreparedStatement statement = this.jdbcTemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM trip WHERE startpoint = ? AND  endpoint = ?");
            statement.setString(1, startpoint);
            statement.setString(2, endpoint);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                trips.add(Trip.fillFromResultSet(set));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trips;
    }

}
