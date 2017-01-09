package estate_service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ricardobaumann on 08/01/17.
 */
@Repository
public interface EstateRepository extends PagingAndSortingRepository<Estate,Long>{
}
