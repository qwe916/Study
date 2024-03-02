package com.design.design_pattern_study.singleton_pattern.singleton;

public class BillPughSolutionSingleton {
    //싱글톤 객체를 담을 인스턴스 변수
    private BillPughSolutionSingleton() {
    }

    //외부에서 정적 메서드 호출하면 인스턴스가 있으면 그대로 반환하고 없으면 생성하여 반환(지연 초기화)
    //static 내부 클래스를 이용하여 싱글톤 객체를 생성, Holder 로 만들어, 클래스가 메모리에 로드되지 않고 getInstance() 메서드가 호출될 때 로드됨
    private static class SingletonHelper {
        private static final BillPughSolutionSingleton INSTANCE = new BillPughSolutionSingleton();
    }

    public static BillPughSolutionSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
