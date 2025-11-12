package com.christmas.api.domain.service.mapper;

import com.christmas.api.domain.ProductTest;
import com.christmas.api.infrastructure.controller.ProductTestDto;
import com.christmas.api.infrastructure.repository.ProductTestEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductTestMapper {

    List <ProductTest> toDomain (List<ProductTestEntity> listProductsTestEntity);

    List <ProductTestDto> toDto (List<ProductTest> listProductsTestDto);

    ProductTestDto toDto (ProductTest productTest);

    ProductTest toDomain (ProductTestEntity productTestEntity);

    ProductTest toDomain (ProductTestDto productTestDto);

    ProductTestEntity toEntity (ProductTest productTest);

}
