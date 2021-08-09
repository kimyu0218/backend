package com.example.backend.service.implement;

import com.example.backend.dao.RouteDao;
import com.example.backend.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmergencyServiceImpl implements EmergencyService, Runnable {

    @Autowired
    RouteDao routeDao;

    @Override
    public void deletePassedNode(int emergency_car_id) { // 예상 시각 지나간 경우 노드 삭제
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(new Date());

        int deleteCount = routeDao.deleteRoute(emergency_car_id, now);
        System.out.println(deleteCount + "개의 노드를 삭제했습니다.");
    }

    @Override
    public void run() { // (불필요한 경우 추후에 삭제)
        boolean con = true;
        while(con){
            deletePassedNode(1);
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
