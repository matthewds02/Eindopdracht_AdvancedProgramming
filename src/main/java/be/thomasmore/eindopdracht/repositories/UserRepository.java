package be.thomasmore.eindopdracht.repositories;

import be.thomasmore.eindopdracht.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String name);
}
