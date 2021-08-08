package com.example.backend.service.implement;

import com.example.backend.dao.RouteDao;
import com.example.backend.dto.Route;
import com.example.backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService, Runnable{

    @Autowired
    private RouteDao routeDao;

    @Override
    public void findClosestNode() {
        List<Route> list = routeDao.findClosestNode();
        System.out.println(list);
    }

    @Override
    public void run() {
        boolean con = true;
        while(con){
            findClosestNode();
            try{ // 필요에 따라 sleep 위치 변경하기
                Thread.sleep(5000);
            } catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println("프론트엔드와 통신하기"); // ==== 프론트엔드와 통신 구현하기 ====
            // 프론트엔드와 통신해서 continue 여부 결정하기
        }
    }
}
