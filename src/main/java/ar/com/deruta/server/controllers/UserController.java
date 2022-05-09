package ar.com.deruta.server.controllers;

import ar.com.deruta.server.models.Contact;
import ar.com.deruta.server.models.DataUser;
import ar.com.deruta.server.models.User;
import ar.com.deruta.server.models.utils.Coordinates;
import ar.com.deruta.server.services.ContactService;
import ar.com.deruta.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/addContact/{contact}")
    public void addContact(@PathVariable String contact) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a != null) {
            User loggedUser = userService.findByUsername(((User)a.getPrincipal()).getUsername());
            User contactUser = userService.findByUsername(contact);
            if (contactUser != null) {
                contactService.save(new Contact(loggedUser, contactUser, true));
            }
        }
    }

    @GetMapping("/contacts")
    public List<DataUser> getContacts() {
        System.out.println("init getContacts");
        List<DataUser> contacts = new ArrayList<>();
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a != null) {
            User loggedUser = userService.findByUsername((String)a.getPrincipal());
            contacts.add(new DataUser(loggedUser.getId(), loggedUser.getUsername(), loggedUser.getCoordinates(), false, loggedUser.getPictureLastUpdated().getTime(), loggedUser.getName()));
            contacts.addAll(loggedUser.getContacts().stream().map(c -> new DataUser(c.getContact().getId(), c.getContact().getUsername(), c.getContact().getCoordinates(), c.getPictureUpdated(), c.getContact().getPictureLastUpdated() != null ? c.getContact().getPictureLastUpdated().getTime() : null, c.getContact().getName())).collect(Collectors.toSet()));
        }
        System.out.println("return getContacts");
        return contacts;
    }

    @PostMapping("/updateLocation")
    public void updateLocation(@RequestBody Coordinates coordinates) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a != null) {
            User loggedUser = userService.findByUsername((String)a.getPrincipal());
            loggedUser.setCoordinates(coordinates);
            loggedUser.setCoordinatesLastUpdated(new Date());
            userService.save(loggedUser);
        }
    }

    @PostMapping("/pictureUpdated")
    public Long pictureUpdated() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a != null) {
            User loggedUser = userService.findByUsername((String)a.getPrincipal());
            Date now = new Date();
            loggedUser.setPictureLastUpdated(now);
            userService.save(loggedUser);
            return now.getTime();
        }
        return null;
    }
}
