package com.christmas.api.domain.service;

import com.christmas.api.domain.ProductTest;
import com.christmas.api.domain.service.mapper.IProductTestMapper;
import com.christmas.api.infrastructure.controller.exceptions.ProductTestNotFoundException;
import com.christmas.api.infrastructure.repository.ProductTestEntity;
import com.christmas.api.infrastructure.repository.ProductTestRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductTestServiceTest {

    @Mock
    private ProductTestRepository mockRepository;

    @Mock
    private IProductTestMapper mockMapper;

    @InjectMocks
    private ProductTestService service;

    @Nested
    public class when_product_test_is_found  {

        @Test
        void should_return_product_test () {

            ProductTestEntity entity = new ProductTestEntity(1, "description", 10.22F);

            ProductTest expected = new ProductTest(1, "description", 10.22F);

            when(mockRepository.getProductTestById(1)).thenReturn(Optional.of(entity));

            when(mockMapper.toDomain(entity)).thenReturn(expected);

            ProductTest result = service.getProductTestById(1);

            assertEquals(expected, result);

            verify(mockRepository).getProductTestById(1);
        }

    }

    @Nested
    public class when_product_test_is_not_found {

        @Test
        void should_throw_exception () {

            when(mockRepository.getProductTestById(1).map(mockMapper::toDomain))
                    .thenReturn(Optional.empty());

            assertThrows(ProductTestNotFoundException.class, () -> {
                service.getProductTestById(1);
            });

            verify(mockRepository).getProductTestById(1);
        }
    }

}
