package com.pachacama.segundocalificado.practicacalificada2.repository;


import com.orm.SugarRecord;
import com.pachacama.segundocalificado.practicacalificada2.models.Product;

import java.util.List;

public class ProductRepository {

    public static List<Product> list(){
        List<Product> products = SugarRecord.listAll(Product.class);
        return products;
    }

    public static Product read(Long id){
        Product product = SugarRecord.findById(Product.class, id);
        return product;
    }

    public static void create(String product_name, String product_price, String product_desc, String product_state, Long id_user){
        Product product = new Product(product_name, product_price,  product_desc, product_state, id_user);
        SugarRecord.save(product);
    }



}
