package com.example.spring.Lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
public class PrototypeClientManager {
    @Autowired
    private ObjectFactory<PrototypeClient> prototypeClientFactory;

    public void createAndUsePrototypeClient() {
        PrototypeClient prototypeClient = prototypeClientFactory.getObject();
        prototypeClient.init(); // 초기화 메서드 호출
        // ... 사용 로직 ...
        prototypeClient.destroy(); // 수동으로 소멸 메서드 호출
    }
}
