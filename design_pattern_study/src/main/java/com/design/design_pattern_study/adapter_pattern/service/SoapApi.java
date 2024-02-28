package com.design.design_pattern_study.adapter_pattern.service;

public class SoapApi {
    public void call(String endpoint, String action, String message) {
        System.out.println("SOAP API is called");
        System.out.println("Endpoint: " + endpoint + ", Action: " + action + ", Message: " + message);
    }
}