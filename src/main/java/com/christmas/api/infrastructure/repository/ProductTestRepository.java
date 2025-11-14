package com.christmas.api.infrastructure.repository;

import com.christmas.api.domain.ProductTest;
import com.christmas.api.domain.service.mapper.IProductTestMapper;
import com.christmas.api.infrastructure.controller.exceptions.ProductTestNotFoundException;
import com.christmas.api.infrastructure.repository.persistence.mapper.IProductTestMyBatis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductTestRepository {

    private final IProductTestMyBatis productTestMyBatis;

    private  final IProductTestMapper productTestMapper;

    public List <ProductTestEntity> getProductsTest() {

        return productTestMyBatis.getProductsTest();

    }

    public Optional<ProductTestEntity> getProductTestById(Integer id) {
        return productTestMyBatis.getProductTestById(id);
    }

    public ProductTestEntity createProductTest(ProductTest productTestToCreate) {

        ProductTestEntity entity = productTestMapper.toEntity(productTestToCreate);

        productTestMyBatis.createProductTest(entity);

        return entity;

    }

    public ProductTestEntity updateProductTest(Integer id, ProductTest productTestToUpdate) {

        ProductTestEntity entity = productTestMapper.toEntity(productTestToUpdate);

        productTestMyBatis.updateProductTest(id, entity);

        return entity;
    }

    public ProductTestEntity updatePartiallyProductTest(Integer id, ProductTest productTestToUpdate) {

       ProductTestEntity entity = productTestMapper.toEntity(productTestToUpdate);

       productTestMyBatis.updatePartiallyProductTest(id, entity);

       return  entity;
    }

    public void deleteProductTestById(Integer id) {

        productTestMyBatis.deleteProductTestById(id);

    }
}
