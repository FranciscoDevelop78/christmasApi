package com.christmas.api.infrastructure.controller;

import com.christmas.api.application.IProductTestUseCase;
import com.christmas.api.domain.ProductTest;
import com.christmas.api.domain.service.mapper.IProductTestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("christmas/api/products/test")
public class ProductTestController {

    private final IProductTestUseCase iListProductsTestUseCase;

    private final IProductTestMapper iProductTestMapper;

    @GetMapping("")
    public ResponseEntity <List <ProductTestDto>> getProductsTest() {

        return ResponseEntity.ok (
                iProductTestMapper.toDto(iListProductsTestUseCase.getProductsTest())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTestDto> getProductTest(@PathVariable("id") Integer id) {
        return ResponseEntity.ok (
                iProductTestMapper.toDto(iListProductsTestUseCase.getProductTestById(id) )
        );
    }

    @PostMapping("/create")
    public  ResponseEntity<ProductTestDto> createProductTest(@RequestBody ProductTestDto requestBody) {

        ProductTestDto productTestCreated = iProductTestMapper.toDto(iListProductsTestUseCase.createProductTest(requestBody) );

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("christmas/api/products/test/{id}")
                .buildAndExpand(productTestCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(productTestCreated);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<ProductTestDto> updateProductTest(@PathVariable("id") Integer id, @RequestBody ProductTestDto requestBody) {

        ProductTest productTestUpdated =  iListProductsTestUseCase.updateProductTest(id, requestBody);

        productTestUpdated.setId(id);

        ProductTestDto productTestDtoUpdated = iProductTestMapper.toDto(productTestUpdated);

        return ResponseEntity.ok(productTestDtoUpdated);

    }

    @PatchMapping("/modify/{id}")
    public ResponseEntity<ProductTestDto> updatePartiallyProductTest(@PathVariable("id") Integer id, @RequestBody ProductTestDto requestBody) {

        ProductTest productTestUpdated = iListProductsTestUseCase.updatePartiallyProductTest(id, requestBody);

        productTestUpdated.setId(id);

        ProductTestDto productTestDtoUpdated = iProductTestMapper.toDto(productTestUpdated);

        return  ResponseEntity.ok(productTestDtoUpdated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductTestDto> deleteProductTest(@PathVariable("id") Integer id) {

        iListProductsTestUseCase.deleteProductTestById(id);

        return ResponseEntity.noContent().build();

    }

}

