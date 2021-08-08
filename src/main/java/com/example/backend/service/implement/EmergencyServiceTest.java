package com.example.backend.service.implement;

import com.example.backend.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmergencyServiceTest {
    public static void main(String[] args){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        EmergencyServiceImpl emergencyService = ac.getBean(EmergencyServiceImpl.class);

        // deletePassedNode
        emergencyService.run();
        // emergencyCarId 임의로 1로 설정해놓은 상태
        // 프론트랑 통신하면서 id 부여해서 설정하는 과정 필요
    }
}
