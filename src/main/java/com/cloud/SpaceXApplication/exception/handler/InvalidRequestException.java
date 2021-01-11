package com.cloud.SpaceXApplication.exception.handler;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InvalidRequestException extends RuntimeException {

    private final String code;

    public InvalidRequestException(String errorMessage, String code) {
        super(errorMessage);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}