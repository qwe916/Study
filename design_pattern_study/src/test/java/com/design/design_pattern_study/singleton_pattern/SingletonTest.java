package com.design.design_pattern_study.singleton_pattern;

import com.design.design_pattern_study.singleton_pattern.singleton.Singleton;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class SingletonTest {
    @Test
    void 싱글톤_테스트(){
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Assertions.assertThat(singleton).isEqualTo(singleton1);
    }

    @Test
    void 싱글톤_멀티_쓰레드_문제(){
        // 1. 싱글톤 객체를 담을 배열
        Singleton[] singleton = new Singleton[10];

        // 2. 스레드 풀 생성
        ExecutorService service = Executors.newCachedThreadPool();

        // 3. 반복문을 통해 10개의 스레드가 동시에 인스턴스 생성
        for (int i = 0; i < 10; i++) {
            final int num = i;
            service.submit(() -> {
                singleton[num] = Singleton.getInstance();
            });
        }

        // 4. 종료
        service.shutdown();

        // 5. 싱글톤 객체 주소 출력
        for(Singleton s : singleton) {
            System.out.println(s.toString());
        }
    }
}