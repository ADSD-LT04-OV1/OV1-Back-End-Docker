package com.example.demo.vehicle;

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
@RequestMapping("api/v1/vehicle")

public class VehicleController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public ArrayList<Vehicle> getAll() throws SQLException{
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Statement statement = this.jdbcTemplate.getDataSource().getConnection().createStatement();
        ResultSet set = statement.executeQuery("select * from vehicle");
        while (set.next()){
            vehicles.add(Vehicle.fillFromResultSet(set));
        }
        statement.close();
        set.close();
        return vehicles;
    }

    @GetMapping(path = "/{id}")
    public ArrayList<Vehicle> findById(@PathVariable("id") final int id){
        final ArrayList<Vehicle> vehicles = new ArrayList<>();
        try{
            PreparedStatement statement = this.jdbcTemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM vehicle WHERE id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                vehicles.add(Vehicle.fillFromResultSet(set));
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
}
