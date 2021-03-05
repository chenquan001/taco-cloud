package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import tacos.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
}