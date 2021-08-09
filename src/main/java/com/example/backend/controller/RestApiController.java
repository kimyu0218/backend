package com.example.backend.controller;

import com.example.backend.dao.RouteDao;
import com.example.backend.etc.DriverForm;
import com.example.backend.service.DriverService;
import com.example.backend.service.EmergencyService;
import com.example.backend.service.implement.DirectionSearchServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class RestApiController { // 프론트엔드와 통신

    @Autowired
    DirectionSearchServiceImpl directionSearchService;

    @Autowired
    DriverService driverService;

    @Autowired
    EmergencyService emergencyService;

    @Autowired
    RouteDao routeDao;

    // Emergency Car Service (파라미터 형태)
    // 응급 차량에게 최적의 경로 제공
    @PostMapping (value = "/api/drive")
    public double[][] drive(@RequestParam ("auth") int auth,
                            @RequestParam("start_lat") double start_lat, @RequestParam("start_lng") double start_lng,
                            @RequestParam("end_lat") double end_lat, @RequestParam("end_lng") double end_lng) throws IOException, ParseException {
        return directionSearchService.findRoute(auth, start_lng, start_lat, end_lng, end_lat);
    }

    // Driver Service
    // 일반 차량에게 현재 시각과 가장 가까운 시각 노드 정보 제공
    @GetMapping (value = "/api/driver")
    public DriverForm driver_service(){
        if(routeDao.isEmpty() == 0) { // 데이터베이스에 아무런 경로 정보가 없는 경우
            DriverForm form = new DriverForm();
            form.setSuccess(false);
            return form;
        }
        return driverService.findClosestNode();
    }

    // Emergency Car Service
    // 예상 시각이 지나간 노드 삭제
    @PostMapping(value = "/api/emergency")
    public void emergency_service(@RequestParam("emergency_car_id") int emergencyCarId){
        emergencyService.deletePassedNode(emergencyCarId);
    }
}
