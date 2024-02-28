package com.design.design_pattern_study.adapter_pattern.client;

public class Client {
    private final RestApi restApi;

    public Client(RestApi restApi) {
        this.restApi = restApi;
    }

    public void execute() {
        restApi.get("/api");
    }
}