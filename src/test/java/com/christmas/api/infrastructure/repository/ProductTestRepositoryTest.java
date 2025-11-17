package com.christmas.api.infrastructure.repository;

import com.christmas.api.infrastructure.repository.persistence.mapper.IProductTestMyBatis;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductTestRepositoryTest {

    @Mock
    private IProductTestMyBatis mockBatis;

    @InjectMocks
    private ProductTestRepository repository;

    @Nested
    public  class when_product_test_is_found  {
        @Test
        void should_return_a_product_test() {

            ProductTestEntity entityExpected = new ProductTestEntity(1, "description", 10.23F);

            when(mockBatis.getProductTestById(1)).thenReturn(Optional.of(entityExpected));

            ProductTestEntity entityResult = repository.getProductTestById(1).get();

            assertEquals(entityExpected, entityResult);

            verify(mockBatis).getProductTestById(1);

        }

    }

   @Nested
    public  class when_product_test_is_not_found {
        @Test
        void should_return_null() {

            ProductTestEntity entityExpected = null;

            when(mockBatis.getProductTestById(1)).thenReturn(Optional.empty());

            ProductTestEntity entityResult = repository.getProductTestById(1).orElse(null);

            assertEquals(entityExpected, entityResult);

            verify(mockBatis).getProductTestById(1);

        }
    }
}
