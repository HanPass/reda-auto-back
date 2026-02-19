package com.store.domain.ports;

import com.store.domain.model.Supplier;
import java.util.List;
import java.util.Optional;

public interface SupplierPort {
    Supplier save(Supplier supplier);
    Optional<Supplier> findById(Long id);
    List<Supplier> findAll();
    void deleteById(Long id);
}
