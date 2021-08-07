package com.example.backend.controller;

import com.example.backend.dao.RouteDao;
import com.example.backend.dao.TrafficLightDao;
import com.example.backend.service.implement.DirectionSearchServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class RestApiController {
    @Autowired
    TrafficLightDao trafficLightDao;
    
    @Autowired
    RouteDao routeDao;
    
    @GetMapping("/home")
    public String welcome(){
        return "The Server is running...";
    }
    
    @PostMapping("/")
    public double[][] driver(@RequestParam("auth") int auth,
                         @RequestParam("start_lat") double start_lat, @RequestParam("start_lng") double start_lng,
                         @RequestParam("end_lat") double end_lat, @RequestParam("end_lng") double end_lng) throws IOException, ParseException {

        if(auth == 1) System.out.println("Emergency Car..."); // (추후에 삭제)
        else System.out.println("Driver...");

        DirectionSearchServiceImpl service = new DirectionSearchServiceImpl();
        return service.findRoute(auth, start_lng, start_lat, end_lng, end_lat); // (emergency_car 경로 db에 저장됨)
    }
}
