package ar.com.deruta.server.models;

import ar.com.deruta.server.models.utils.Coordinates;

import java.io.Serializable;

public class PlacePreview {

    private String id;
    private String name;
    private PlaceType type;
    private Coordinates coordinates;

    public PlacePreview(String id, String name, PlaceType type, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
