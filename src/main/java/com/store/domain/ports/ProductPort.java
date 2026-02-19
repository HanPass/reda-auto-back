package com.store.domain.ports;

import com.store.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductPort {
    Product save(Product product);
    Optional<Product> findById(Long id);
    Optional<Product> findByReference(String reference);
    List<Product> findAll();
    List<Product> findByNomContaining(String nom);
    List<Product> findLowStock();
    void deleteById(Long id);
}
