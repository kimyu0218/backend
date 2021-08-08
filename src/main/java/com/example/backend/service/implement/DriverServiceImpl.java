package com.example.backend.service.implement;

import com.example.backend.dao.RouteDao;
import com.example.backend.dto.Route;
import com.example.backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private RouteDao routeDao;

    @Override
    public Date computeTime() { // 현재 시각 계산하기
        return new Date();
    }

    @Override
    public void deletePassedNode(Date time) { // 예상 시각이 지난 노드 삭제
        while(true) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Date now = computeTime();
                    List<Route> list = routeDao.findClosestNode(time);
                    System.out.println(list);
                    //System.out.println(deleteCount + "개 삭제");
                }
            };
            timer.schedule(task, 5000);
        }
    }
}
