package com.health.service;

import com.health.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    Product save(Product product);
    Product update(Integer id, Product product);
    void delete(Integer id); // ✅ Agrega esta línea
}
