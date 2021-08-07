package com.example.backend.controller;

import com.example.backend.dao.RouteDao;
import com.example.backend.dao.TrafficLightDao;
import com.example.backend.etc.Form;
import com.example.backend.service.DirectionSearchService;
import com.example.backend.service.implement.DirectionSearchServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class RestApiController {

    @Autowired
    DirectionSearchServiceImpl directionSearchService;

    @GetMapping("/home")
    public String welcome(){
        return "The Server is running...";
    }
    
    @PostMapping("/")
    public double[][] drive(Form form) throws IOException, ParseException {
        if(form.getAuth() == 1) System.out.println("Emergency Car..."); // (추후에 삭제)
        else System.out.println("Driver...");
        return directionSearchService.findRoute(form.getAuth(), form.getStart_lng(), form.getStart_lat(), form.getEnd_lng(), form.getStart_lat());
    }
}
