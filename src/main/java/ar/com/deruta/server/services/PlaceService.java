package ar.com.deruta.server.services;

import ar.com.deruta.server.models.Place;
import ar.com.deruta.server.models.enums.Repository;
import ar.com.deruta.server.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getAll() {
        return (List<Place>)placeRepository.findAll();
    }

    public Place save(Place place) {
        return placeRepository.save(place);
    }

    public List<Place> findByDeletionFlag(Boolean deletionFlag) {
        return placeRepository.findByDeletionFlag(deletionFlag);
    }

    public Place findPlaceByIdAndRepository(Long id, Repository repository) {
        return placeRepository.findPlaceByIdAndRepository(id, repository);
    }

}
