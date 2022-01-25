package ar.com.deruta.server.models;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Picture {

    @NotNull
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
