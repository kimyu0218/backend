package com.example.backend.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.example.backend.etc.Coordinate;

public interface DirectionSearchService {
    public double cal_ang(Coordinate a, Coordinate b, Coordinate c);
    public long traffic_value (int i, int j, double path[][][], long time_plus, double location[], double goal[]);
    public double[][] findRoute(int auth, double src_longitude, double src_latitude, double dst_longitude, double dst_latitude) throws IOException, ParseException;
}
