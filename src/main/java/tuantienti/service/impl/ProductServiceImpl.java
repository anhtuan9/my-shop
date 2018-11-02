package tuantienti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import tuantienti.model.product;
import tuantienti.repository.ProductRepository;
import tuantienti.service.ProductService;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Iterable<product> findbyname(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Iterable<product> findbyprice(double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public Iterable<product> findbyproducer(String producer) {
        return productRepository.findByProducer(producer);
    }

    @Override
    public Iterable<product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void remove(long id) {
        productRepository.delete(id);
    }

    @Override
    public void add(product product) {
        productRepository.save(product);
    }
}
