package com.example.springboot.repositories;

import com.example.springboot.modes.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
//* Nesse caso não era necessario a anotattion porque
// como estou extendendo o JPA o spring já reconhece como Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {



}
