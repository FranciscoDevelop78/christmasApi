package com.christmas.api.infrastructure.controller.exceptions.handler;

import com.christmas.api.infrastructure.controller.exceptions.ProductTestNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductTestNotFoundException.class)
    public ProblemDetail handleProductTestNotFound(ProductTestNotFoundException ptError, WebRequest request) {

       ProblemDetail notFoundProblem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ptError.getMessage());

       notFoundProblem.setTitle(ptError.getErrorName());

       notFoundProblem.setDetail(ptError.getMessage());

       notFoundProblem.setType(URI.create("http://christmasApi.com/error/product-test-not-found"));

       return notFoundProblem;

    }

}
