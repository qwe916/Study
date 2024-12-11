package com.example.spring.Lifecycle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class LifeCycleTest {
    @Test
    void 빈_라이프사이클_테스트() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtx.class,Dependency.class);

        appCtx.close();
    }

    @Test
    void 커스텀_메서드를_이용한_객체_초기화와_소멸() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtxWithCustomMethod.class, Dependency.class);

        appCtx.close();
    }

    @Test
    void 초기화된_빈_객체는_싱글톤이다() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtx.class, Dependency.class);

        Client client1 = appCtx.getBean("client", Client.class);
        Client client2 = appCtx.getBean("client", Client.class);

        appCtx.close();

        Assertions.assertThat(client1).isEqualTo(client2);
    }

    @Test
    void 프로토타입_객체는_서로_다른_객체() {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppCtxPrototype.class, Dependency.class);

        PrototypeClient prototypeClient1 = appCtx.getBean("prototypeClient", PrototypeClient.class);
        PrototypeClient prototypeClient2 = appCtx.getBean("prototypeClient", PrototypeClient.class);

        appCtx.close();

        Assertions.assertThat(prototypeClient1).isNotSameAs(prototypeClient2);
    }
}