package be.thomasmore.eindopdracht.repositories;

import be.thomasmore.eindopdracht.model.Images;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImageRepository extends CrudRepository<Images, Integer> {
    @Query("SELECT i FROM Images i")
    Iterable<Images> findAllImages();
}
