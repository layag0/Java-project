package merito.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    Iterable<User> findAll(Sort wins);
}