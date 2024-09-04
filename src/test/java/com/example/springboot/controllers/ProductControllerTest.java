package com.example.springboot.controllers;


import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productControllerT;

    @Mock
    private ProductRepository productRepositoryT;

    @Test
    @DisplayName("Deve retornar uma lista de todos os produtos")
    public void buscarTodos(){
        //Deve retornar uma lista de todos os produtos
        ResponseEntity<List<ProductModel>> usuarios = productControllerT.getAllProduct();
    }

    @Test
    @DisplayName("Deve lançar exceção quando dado inserido for diferente do esperado")
    public void inserirDado(){

    }

}