//package com.example.demo.trip;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface TripRepository extends JpaRepository<Trip, Long> {
//    @Query("SELECT p FROM trip as p where p.startpoint like %?1% ")
//    List<Trip> findByStartpoint(String startpoint);
//
//}
