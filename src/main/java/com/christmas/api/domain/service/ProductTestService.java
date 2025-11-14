package com.christmas.api.domain.service;

import com.christmas.api.application.IProductTestUseCase;
import com.christmas.api.domain.ProductTest;
import com.christmas.api.domain.service.mapper.IProductTestMapper;
import com.christmas.api.infrastructure.controller.ProductTestDto;
import com.christmas.api.infrastructure.controller.exceptions.ProductTestNotFoundException;
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

        return productTestRepository.getProductTestById(id)
                .map(iProductTestMapper::toDomain)
                .orElseThrow( () -> new ProductTestNotFoundException(id));
    }

    @Override
    public ProductTest createProductTest(ProductTestDto productTestDtoToCreate) {

         ProductTest domainFromDto = iProductTestMapper.toDomain(productTestDtoToCreate);

         ProductTestEntity entity = productTestRepository.createProductTest(domainFromDto);

         return  iProductTestMapper.toDomain(entity);

    }

    @Override
    public ProductTest updateProductTest(Integer id, ProductTestDto productTestDtoToUpdate) {

        if (productTestRepository.getProductTestById(id).isEmpty())
            throw new  ProductTestNotFoundException(id);

        ProductTest domainFromDto = iProductTestMapper.toDomain(productTestDtoToUpdate);

        ProductTestEntity entity = productTestRepository.updateProductTest(id, domainFromDto);

        return iProductTestMapper.toDomain(entity);

    }

    @Override
    public ProductTest updatePartiallyProductTest(Integer id, ProductTestDto productTestDtoToUpdate) {

        if (productTestRepository.getProductTestById(id).isEmpty())
            throw new  ProductTestNotFoundException(id);

        ProductTest domainFromDto = iProductTestMapper.toDomain(productTestDtoToUpdate);

        ProductTestEntity entity = productTestRepository.updateProductTest(id, domainFromDto);

        return iProductTestMapper.toDomain(entity);

    }

    @Override
    public void deleteProductTestById(Integer id) {

        if (productTestRepository.getProductTestById(id).isEmpty())
            throw new  ProductTestNotFoundException(id);

        productTestRepository.deleteProductTestById(id);

    }
}
