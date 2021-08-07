package com.example.backend.etc;

import org.springframework.web.bind.annotation.RequestBody;

public class Form {
    private int auth;
    private double start_lat;
    private double start_lng;
    private double end_lat;
    private double end_lng;

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public double getStart_lat() {
        return start_lat;
    }

    public void setStart_lat(double start_lat) {
        this.start_lat = start_lat;
    }

    public double getStart_lng() {
        return start_lng;
    }

    public void setStart_lng(double start_lng) {
        this.start_lng = start_lng;
    }

    public double getEnd_lat() {
        return end_lat;
    }

    public void setEnd_lat(double end_lat) {
        this.end_lat = end_lat;
    }

    public double getEnd_lng() {
        return end_lng;
    }

    public void setEnd_lng(double end_lng) {
        this.end_lng = end_lng;
    }
}
