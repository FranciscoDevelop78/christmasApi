package com.christmas.api.infrastructure.controller;

import com.christmas.api.application.IProductTestUseCase;
import com.christmas.api.domain.ProductTest;
import com.christmas.api.domain.service.mapper.IProductTestMapper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductTestControllerTest {

    @Mock
    private IProductTestUseCase useCaseMock;

    @Mock
    private IProductTestMapper mapperMock;

    @InjectMocks
    private ProductTestController controller;

    @Nested
    public class when_product_test_is_found {
        @Test
        void should_return_dto_response () {

            ProductTest productTest = new ProductTest(1, "description", 10.23F);

            ProductTestDto dto =  new ProductTestDto(1, "description", 10.23F);

            ResponseEntity<ProductTestDto> expected =  ResponseEntity.ok(dto);

            when(useCaseMock.getProductTestById(1)).thenReturn(productTest);

            when(mapperMock.toDto(productTest)).thenReturn(dto);

            ResponseEntity<ProductTestDto> result =  controller.getProductTest(1);

            assertEquals(expected, result);

            verify(useCaseMock).getProductTestById(1);

        }
    }
}
