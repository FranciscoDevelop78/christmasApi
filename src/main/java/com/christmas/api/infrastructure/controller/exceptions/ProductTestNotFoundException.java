package com.christmas.api.infrastructure.controller.exceptions;

import com.christmas.api.infrastructure.controller.exceptions.baseException.BaseProductTestException;
import lombok.Getter;

@Getter
public class ProductTestNotFoundException  extends BaseProductTestException {

    private  final Integer id;

    public ProductTestNotFoundException (Integer id) {

        super("Product test identified by " + id + " don't exists.", "PRODUCT_TEST_NOT_FOUND");

        this.id = id;

    }

}
