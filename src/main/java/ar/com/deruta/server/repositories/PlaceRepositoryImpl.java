package ar.com.deruta.server.repositories;

import ar.com.deruta.server.models.Place;
import ar.com.deruta.server.models.utils.Region;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PlaceRepositoryImpl implements PlaceRepositoryCustom {

    @Autowired
    @Lazy
    PlaceRepository placeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Place> findByRegion(Region region) {
        return entityManager.createQuery(
                "SELECT p FROM Place p " +
                "WHERE p.coordinates.latitude BETWEEN :latitudeFrom AND :latitudeTo " +
                "AND p.coordinates.longitude BETWEEN :longitudeFrom AND :longitudeTo")
                .setParameter("latitudeFrom", region.getMinLat())
                .setParameter("latitudeTo", region.getMaxLat())
                .setParameter("longitudeFrom", region.getMinLng())
                .setParameter("longitudeTo", region.getMaxLng())
                .getResultList();
    }

}
