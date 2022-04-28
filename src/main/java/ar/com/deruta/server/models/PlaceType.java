package ar.com.deruta.server.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "place_type")
public class PlaceType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
