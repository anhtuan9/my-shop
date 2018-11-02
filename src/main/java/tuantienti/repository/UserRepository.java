package tuantienti.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tuantienti.model.Users;

public interface UserRepository extends PagingAndSortingRepository<Users, Long> {

}
