package ar.com.deruta.server.repositories;

import ar.com.deruta.server.models.PlaceType;
import ar.com.deruta.server.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceTypeRepository extends JpaRepository<PlaceType, Long> {

    PlaceType findByName(String name);

}