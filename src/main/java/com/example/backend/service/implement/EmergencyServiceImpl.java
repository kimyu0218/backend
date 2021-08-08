package com.example.backend.service.implement;

import com.example.backend.dao.RouteDao;
import com.example.backend.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class EmergencyServiceImpl implements EmergencyService {
    @Autowired
    RouteDao routeDao;

    @Override
    public void deletePassedNode(int emergency_car_id) { // 예상 시각 지나간 경우 노드 삭제
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int deleteCount = routeDao.deleteRoute(emergency_car_id, new Date());
                System.out.println(deleteCount + "개의 노드를 삭제했습니다.");
                // ===== 추후에 프론트엔드에 전송 필요 ====
                // 현재 구현 상황: 5초 지나고 난 후에 예상 시각을 지나간 노드 삭제하기
                // 구현해야 하는 것: 5초마다 예상 시각을 지나간 노드 삭제하기
            }
        };
        timer.schedule(task, 5000);
    }
}
