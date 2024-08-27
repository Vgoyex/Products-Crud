package com.example.springboot.modes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;


@Entity
@Table(name= "Tb_Products")
public class ProductModel  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    //* Faz com que os Ids sejam gerados automaticamente
    @GeneratedValue(strategy = GenerationType.AUTO) //Poderia substituir AUTO por UUID
    //* No caso do MySql para fazer a consulta por id direto no banco
    //* é necessario fazer uma conversao como esta abaixo:
    //* select * from tb_products where bin_to_uuid(id_product)

    //* Colunas no Banco(MySql nesse caso)
    private UUID idProduct;
    private String name;
    private BigDecimal value;

    public void setIdProduct(UUID id){
        this.idProduct = id;
    }

    public UUID getIdProduct(){
        return idProduct;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setValue(BigDecimal value){
        this.value = value;
    }

    public BigDecimal getValue(){
        return value;
    }


}   
