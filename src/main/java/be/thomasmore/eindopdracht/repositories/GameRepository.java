package be.thomasmore.eindopdracht.repositories;

import be.thomasmore.eindopdracht.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
