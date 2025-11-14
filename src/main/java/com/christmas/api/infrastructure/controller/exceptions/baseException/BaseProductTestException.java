package com.christmas.api.infrastructure.controller.exceptions.baseException;

import lombok.Getter;

@Getter
public abstract  class BaseProductTestException extends  RuntimeException {

    private final String errorName;

    public BaseProductTestException(String message, String errorName) {

        super(message);

        this.errorName = errorName;

    }

}
