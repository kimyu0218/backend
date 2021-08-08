package com.example.backend.service;

import java.util.Date;

public interface DriverService {
    public Date computeTime();
    public void deletePassedNode(Date time);
}
