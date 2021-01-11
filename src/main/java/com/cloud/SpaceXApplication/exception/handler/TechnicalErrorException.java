package com.cloud.SpaceXApplication.exception.handler;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TechnicalErrorException extends RuntimeException {

    private final String code;

    public TechnicalErrorException(String msg, String code) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}