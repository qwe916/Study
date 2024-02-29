package com.design.design_pattern_study.proxy_pattern;

import com.design.design_pattern_study.proxy_pattern.client.Client;
import com.design.design_pattern_study.proxy_pattern.proxy.ProtectionProxy;
import com.design.design_pattern_study.proxy_pattern.proxy.Proxy;
import com.design.design_pattern_study.proxy_pattern.proxy.VirtualProxy;
import com.design.design_pattern_study.proxy_pattern.subject.RealSubject;
import org.junit.jupiter.api.Test;

class ProxyPatternTest {
    @Test
    void 기본형_프록시_테스트(){
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        Client client = new Client(proxy);
        client.execute();
    }

    @Test
    void 가상_프록시_테스트(){
        VirtualProxy virtualProxy = new VirtualProxy();
        System.out.println("가상 프록시 생성");
        Client client = new Client(virtualProxy);
        client.execute();
    }

@Test
void 보호_프록시_테스트_접근_허용(){
    RealSubject realSubject = new RealSubject();
    ProtectionProxy protectionProxy = new ProtectionProxy(realSubject, true);
    Client client = new Client(protectionProxy);
    client.execute();
}

@Test
void 보호_프록시_테스트_접근_거부(){
    RealSubject realSubject = new RealSubject();
    ProtectionProxy protectionProxy = new ProtectionProxy(realSubject, false);
    Client client = new Client(protectionProxy);
    client.execute();
}
}