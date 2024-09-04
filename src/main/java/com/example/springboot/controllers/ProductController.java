package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //Nesse caso especificando para a API REST
public class ProductController {

    @Autowired
    ProductRepository productRepository; //Ponto de injeção para ter acesso aos metodos do JPA

    // Post
    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);// Convertendo de DTO para Model
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    // Get All
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    // Get By Id
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable(value="id") UUID id){
        Optional<ProductModel> productObj = productRepository.findById(id);
        if(productObj.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productObj.get());
    }

    // Put by Id
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
    @RequestBody @Valid ProductRecordDto productRecordDto){
        Optional<ProductModel> productObj = productRepository.findById(id);
        if(productObj.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productModel = productObj.get();
        BeanUtils.copyProperties(productRecordDto, productModel);// Convertendo de DTO para Model
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    // Delete by Id
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id){
        Optional<ProductModel> productObj = productRepository.findById(id);
        if(productObj.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        productRepository.delete(productObj.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }


}
