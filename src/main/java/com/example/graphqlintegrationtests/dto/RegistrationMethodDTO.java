package com.example.graphqlintegrationtests.dto;

import com.example.graphqlintegrationtests.domain.RegistrationMethodEnum;

public class RegistrationMethodDTO {
    private RegistrationMethodEnum method;

    public RegistrationMethodEnum getMethod() {
        return method;
    }

    public void setMethod(RegistrationMethodEnum method) {
        this.method = method;
    }
}
