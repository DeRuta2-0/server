package ar.com.deruta.server.services;

import ar.com.deruta.server.models.Place;
import ar.com.deruta.server.models.PlaceType;
import ar.com.deruta.server.models.User;
import ar.com.deruta.server.repositories.PlaceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceTypeService {

    @Autowired
    private PlaceTypeRepository placeTypeRepository;

    public PlaceType findByName(String name) {
        return placeTypeRepository.findByName(name);
    }

    public PlaceType save(PlaceType place) {
        return placeTypeRepository.save(place);
    }

}
