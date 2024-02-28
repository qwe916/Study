package com.design.design_pattern_study.adapter_pattern.adapter;

import com.design.design_pattern_study.adapter_pattern.client.RestApi;
import com.design.design_pattern_study.adapter_pattern.service.SoapApi;

public class SoapToRestAdapter implements RestApi {
    private final SoapApi soapApi;

    public SoapToRestAdapter(SoapApi soapApi) {
        this.soapApi = soapApi;
    }

    public void get(String url) {
        soapApi.call(url, "GET", "");
    }
}