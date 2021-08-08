package com.example.backend.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.backend.config.ApplicationConfig;
import com.example.backend.dto.Route;

import java.util.Date;
import java.util.List;

public class RouteDaoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RouteDao routeDao = ac.getBean(RouteDao.class);

        // 1. insert
        Route route = new Route();
        Date exampleTime = new Date();
        route.setLatitude(37.12345);
        route.setLongitude(127.12345);
        route.setEmergencyCarId(1);
        route.setNodeId(0);
        route.setTime(exampleTime);
        int insertCount = routeDao.insertRoute(route);
        System.out.println(insertCount + "개의 경로를 올렸습니다.");

        // 2. delete by time
        int emergency_car_id = 1;
        Date currentTime = new Date();
        int deleteCount = routeDao.deleteRoute(emergency_car_id, currentTime);
        System.out.println(deleteCount + "개의 경로를 삭제했습니다.");

        // 3. count
        int count = routeDao.isEmpty();
        System.out.println(count + "개의 레코드가 존재합니다.");

        // 4. sort by time
        List<Route> routeList = routeDao.findClosestNode(currentTime);
        System.out.println(routeList);
    }
}
