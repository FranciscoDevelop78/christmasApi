package com.christmas.api.domain.service;

import com.christmas.api.application.IProductTestUseCase;
import com.christmas.api.domain.ProductTest;
import com.christmas.api.domain.service.mapper.IProductTestMapper;
import com.christmas.api.infrastructure.controller.ProductTestDto;
import com.christmas.api.infrastructure.repository.ProductTestEntity;
import com.christmas.api.infrastructure.repository.ProductTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductTestService implements IProductTestUseCase {

    private final ProductTestRepository productTestRepository;

    private final IProductTestMapper iProductTestMapper;

    @Override
    public List <ProductTest> getProductsTest() {

        return iProductTestMapper.toDomain(productTestRepository.getProductsTest());

    }

    @Override
    public ProductTest getProductTestById(Integer id) {

        return iProductTestMapper.toDomain(productTestRepository.getProductTestById(id));

    }

    @Override
    public ProductTest createProductTest(ProductTestDto productTestDtoToCreate) {

         ProductTest domainFromDto = iProductTestMapper.toDomain(productTestDtoToCreate);

         ProductTestEntity entity = productTestRepository.createProductTest(domainFromDto);

         return  iProductTestMapper.toDomain(entity);

    }

    @Override
    public ProductTest updateProductTest(Integer id, ProductTestDto productTestDtoToUpdate) {

        ProductTest domainFromDto = iProductTestMapper.toDomain(productTestDtoToUpdate);

        ProductTestEntity entity = productTestRepository.updateProductTest(id, domainFromDto);

        return iProductTestMapper.toDomain(entity);

    }

    @Override
    public ProductTest updatePartiallyProductTest(Integer id, ProductTestDto productTestDtoToUpdate) {

        ProductTest domainFromDto = iProductTestMapper.toDomain(productTestDtoToUpdate);

        ProductTestEntity entity = productTestRepository.updateProductTest(id, domainFromDto);

        return iProductTestMapper.toDomain(entity);

    }

    @Override
    public void deleteProductTestById(Integer id) {

        productTestRepository.deleteProductTestById(id);

    }
}
