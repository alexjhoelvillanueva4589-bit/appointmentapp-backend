package com.health.service.implementation;

import com.health.model.Product;
import com.health.repository.ProductRepository;
import com.health.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // ✅ Constructor Injection (recomendado en lugar de @Autowired)
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        Product existing = findById(id); // Verifica que exista
        product.setIdProduct(id); // ✅ Usa el nombre correcto de tu campo ID
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        Product existing = findById(id); // Verifica antes de borrar
        productRepository.delete(existing);
    }
}
