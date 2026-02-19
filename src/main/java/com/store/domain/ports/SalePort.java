package com.store.domain.ports;

import com.store.domain.model.Sale;
import java.util.List;

public interface SalePort {
    Sale save(Sale sale);
    List<Sale> findAll();
}
