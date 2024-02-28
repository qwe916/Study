package com.design.design_pattern_study.adapter_pattern;

import com.design.design_pattern_study.adapter_pattern.adapter.SoapToRestAdapter;
import com.design.design_pattern_study.adapter_pattern.client.Client;
import com.design.design_pattern_study.adapter_pattern.client.RestApi;
import com.design.design_pattern_study.adapter_pattern.service.SoapApi;
import org.junit.jupiter.api.Test;

class AdapterPatternTest {
    @Test
    void 어댑터_패턴_테스트() {
        SoapApi soapApi = new SoapApi();
        RestApi adapter = new SoapToRestAdapter(soapApi);
        Client client = new Client(adapter);
        client.execute();
    }
}