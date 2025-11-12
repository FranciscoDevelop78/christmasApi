package com.christmas.api.infrastructure.repository.persistence.mapper;

import com.christmas.api.domain.ProductTest;
import com.christmas.api.infrastructure.repository.ProductTestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IProductTestMyBatis {

    List<ProductTestEntity> getProductsTest ();

    ProductTestEntity getProductTestById (@Param("id") Integer id);

    void  createProductTest(ProductTestEntity productTestToCreate);

    void updateProductTest(@Param("id") Integer id, @Param("productTest") ProductTestEntity productTestToUpdate);

    void updatePartiallyProductTest(@Param("id") Integer id, @Param("productTest") ProductTestEntity productTestToUpdate);

    void deleteProductTestById(@Param("id") Integer id);

}
