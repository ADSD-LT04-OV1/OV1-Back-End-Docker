package com.example.demo.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/trip")
public class TripController {

//    private final Trip trip;
    @Autowired
//    public TripController(final Trip trip){
//        this.trip = trip;
//    }
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public ArrayList<Trip> getAll() throws SQLException {
        ArrayList<Trip> trips = new ArrayList<>();

        Statement statement = this.jdbcTemplate.getDataSource().getConnection().createStatement();
        ResultSet set = statement.executeQuery("select * from trip");
        while (set.next()) {
            trips.add(Trip.fillFromResultSet(set));
        }
        statement.close();
        set.close();
        return trips;
    }

//    @GetMapping(path = "/{startpoint}/{endpoint}")
//    public Trip findByStartpoint(@PathVariable final String startpoint, String endpoint ){
//        Optional<Trip> trip = this.trip.findByStartpoint(startpoint, endpoint);
//
//    }
}
