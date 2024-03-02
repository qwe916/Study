package com.design.design_pattern_study.singleton_pattern.singleton;

public class Singleton {
    //싱글톤 객체를 담을 인스턴스 변수
    private static Singleton instance;

    //생성자를 private으로 선언하여 외부에서 생성자에 접근하지 못하도록 함
    private Singleton() {
    }

    //외부에서 정적 메서드 호출하면 인스턴스가 있으면 그대로 반환하고 없으면 생성하여 반환(지연 초기화)
    public static Singleton getInstance() {
        //싱글톤 객체가 없을 경우에만 객체를 생성
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
