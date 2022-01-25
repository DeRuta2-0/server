package ar.com.deruta.server.models.keys;

import ar.com.deruta.server.models.enums.Repository;

import java.io.Serializable;
import java.util.Objects;

public class PlaceId implements Serializable {

    private Long id;
    private Repository repository;

    public PlaceId() {
    }

    public PlaceId(Long id, Repository repository) {
        this.id = id;
        this.repository = repository;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceId placeId = (PlaceId) o;
        return id.equals(placeId.id) && repository == placeId.repository;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, repository);
    }
}
