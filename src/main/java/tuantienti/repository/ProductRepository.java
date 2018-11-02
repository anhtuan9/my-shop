package tuantienti.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import tuantienti.model.product;

public interface ProductRepository extends PagingAndSortingRepository<product, Long> {
    Iterable<product> findByName(String name);
    Iterable<product> findByPrice(Double price);
    Iterable<product> findByProducer(String producer);
}
