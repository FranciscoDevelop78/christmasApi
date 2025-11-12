package com.christmas.api.application;

import com.christmas.api.domain.ProductTest;
import com.christmas.api.infrastructure.controller.ProductTestDto;

import java.util.List;

public interface IProductTestUseCase {

    List <ProductTest> getProductsTest ();

    ProductTest getProductTestById (Integer id);

    ProductTest createProductTest(ProductTestDto productTestDtoToCreate);

    ProductTest updateProductTest(Integer id, ProductTestDto productTestDtoToUpdate);

    ProductTest updatePartiallyProductTest(Integer id, ProductTestDto productTestDtoToUpdate);

    void deleteProductTestById(Integer id);

}
