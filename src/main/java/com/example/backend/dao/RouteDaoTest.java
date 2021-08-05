package com.example.backend.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.backend.config.ApplicationConfig;
import com.example.backend.dto.Route;

public class RouteDaoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RouteDao routeDao = ac.getBean(RouteDao.class);

        // 1. insert
        Route route = new Route();
        route.setLatitude(37.12345);
        route.setLongitude(127.12345);
        route.setEmergencyCarId(1);
        route.setNodeId(0);
        int insertCount = routeDao.insertRoute(route);
        System.out.println(insertCount + "개의 경로를 올렸습니다.");

        // 2. delete by id
        int emergency_car_id = 1;
        int node_id = 0;
        int deleteCount = routeDao.deleteRoute(emergency_car_id, node_id);
        System.out.println(deleteCount + "개의 경로를 삭제했습니다.");
    }
}
