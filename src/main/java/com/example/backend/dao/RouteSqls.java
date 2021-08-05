package com.example.backend.dao;

public class RouteSqls {
    public static final String DELETE_BY_ID = "DELETE FROM route WHERE node_id = :node_id and emergency_car_id = :emergency_car_id";
}
