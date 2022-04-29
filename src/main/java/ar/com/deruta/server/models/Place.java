package ar.com.deruta.server.models;

import ar.com.deruta.server.models.enums.Repository;
import ar.com.deruta.server.models.keys.PlaceId;
import ar.com.deruta.server.models.utils.Coordinates;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "place")
@IdClass(PlaceId.class)
public class Place {

    @Id
    private Long id;

    @Id
    @Enumerated
    private Repository repository;

    @NotNull
    private String name;

    @OneToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private PlaceType type;

    private String country;

    @Lob
    private String description;

    @ElementCollection
    @CollectionTable(name = "place_x_picture", joinColumns = {@JoinColumn(name = "place_id", referencedColumnName = "id"), @JoinColumn(name = "place_repository", referencedColumnName = "repository")})
    private List<Picture> pictures = new ArrayList<>();

    private Boolean deletionFlag = false;

    @NotNull
    private String lastVisited;

    @Embedded
    @NotNull
    private Coordinates coordinates;

    private Double altitude;

    private String website;

    private String phone;

    @OneToOne
    @JoinColumn(name = "contributor_id", referencedColumnName = "id")
    private User contributor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Boolean getDeletionFlag() {
        return deletionFlag;
    }

    public void setDeletionFlag(Boolean deletionFlag) {
        this.deletionFlag = deletionFlag;
    }

    public String getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(String lastVisited) {
        this.lastVisited = lastVisited;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public User getContributor() {
        return contributor;
    }

    public void setContributor(User contributor) {
        this.contributor = contributor;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
