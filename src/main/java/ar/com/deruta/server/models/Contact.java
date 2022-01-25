package ar.com.deruta.server.models;

import ar.com.deruta.server.models.utils.Coordinates;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="contact_id")
    private User contact;

    private Boolean pictureUpdated;

    public Contact() {
    }

    public Contact(User user, User contact, Boolean pictureUpdated) {
        this.user = user;
        this.contact = contact;
        this.pictureUpdated = pictureUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getContact() {
        return contact;
    }

    public void setContact(User contact) {
        this.contact = contact;
    }

    public Boolean getPictureUpdated() {
        return pictureUpdated;
    }

    public void setPictureUpdated(Boolean pictureUpdated) {
        this.pictureUpdated = pictureUpdated;
    }
}
