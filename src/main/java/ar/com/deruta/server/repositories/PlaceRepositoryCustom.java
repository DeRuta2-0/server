package ar.com.deruta.server.repositories;

import ar.com.deruta.server.models.Place;
import ar.com.deruta.server.models.utils.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlaceRepositoryCustom {

    List<Place> findByRegion(Region region);

}