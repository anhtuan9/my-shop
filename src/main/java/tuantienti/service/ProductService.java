package tuantienti.service;

import org.springframework.data.domain.Pageable;
import tuantienti.model.product;

public interface ProductService {
    Iterable<product> findbyname(String name);
    Iterable<product> findbyprice(double price);
    Iterable<product> findbyproducer(String producer);
    Iterable<product> findAll();
    void remove(long id);
    void add(product product);
}
