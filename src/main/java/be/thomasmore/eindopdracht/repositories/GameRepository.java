package be.thomasmore.eindopdracht.repositories;

import be.thomasmore.eindopdracht.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Integer> {
    Optional<Game> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Game> findFirstByIdGreaterThanOrderById(int id);
    Optional<Game> findFirstByOrderByIdAsc();
    Optional<Game> findFirstByOrderByIdDesc();
    Optional<Game> findById(int id);
}
