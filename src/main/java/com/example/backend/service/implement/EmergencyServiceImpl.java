package com.example.backend.service.implement;

import com.example.backend.dao.RouteDao;
import com.example.backend.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmergencyServiceImpl implements EmergencyService {
    @Autowired
    RouteDao routeDao;

    @Override
    public void deletePassedNode(int emergency_car_id) { // 예상 시각 지나간 경우 노드 삭제
        routeDao.deleteRoute(emergency_car_id, new Date());
    }
}
