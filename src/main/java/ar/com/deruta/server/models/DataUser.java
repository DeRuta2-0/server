package ar.com.deruta.server.models;

import ar.com.deruta.server.models.utils.Coordinates;

import java.util.Date;

public class DataUser {

    private Long id;
    private String username;
    private Coordinates coordinates;
    private Boolean pictureUpdated;
    private Long pictureLastUpdated;

    public DataUser(Long id, String username, Coordinates coordinates, Boolean pictureUpdated, Long pictureLastUpdated) {
        this.id = id;
        this.username = username;
        this.coordinates = coordinates;
        this.pictureUpdated = pictureUpdated;
        this.pictureLastUpdated = pictureLastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Boolean getPictureUpdated() {
        return pictureUpdated;
    }

    public void setPictureUpdated(Boolean pictureUpdated) {
        this.pictureUpdated = pictureUpdated;
    }

    public Long getPictureLastUpdated() {
        return pictureLastUpdated;
    }

    public void setPictureLastUpdated(Long pictureLastUpdated) {
        this.pictureLastUpdated = pictureLastUpdated;
    }
}
