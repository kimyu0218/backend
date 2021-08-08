package com.example.backend.service.implement;

import com.example.backend.dao.RouteDao;
import com.example.backend.dto.Route;
import com.example.backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private RouteDao routeDao;

    @Override
    public void findClosetNode() { // 예상 시각과 가장 유사한 노드 찾기
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<Route> list = routeDao.findClosestNode();
                System.out.println(list);
                // ===== 추후에 프론트엔드에 전송 필요 ====
                // 현재 구현 상황: 5초 지나고 난 후에 예상 시각과 가장 유사한 노드 찾기
                // 구현해야 하는 것: 5초마다 예상 시각과 가장 유사한 노드 찾기
            }
        };
        timer.schedule(task, 5000);
    }
}
