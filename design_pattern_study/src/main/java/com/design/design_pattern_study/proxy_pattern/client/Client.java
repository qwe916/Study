package com.design.design_pattern_study.proxy_pattern.client;

import com.design.design_pattern_study.proxy_pattern.subject.Subject;

public class Client {
    private final Subject subject;

    public Client(Subject subject) {
        this.subject = subject;
    }

    public void execute() {
        subject.action();
    }
}
