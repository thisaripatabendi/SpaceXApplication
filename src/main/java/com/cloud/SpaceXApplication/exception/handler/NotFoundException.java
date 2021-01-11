package com.cloud.SpaceXApplication.exception.handler;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String code;

    public NotFoundException(String msg, String code) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}