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

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public Set<DataUser> getContacts() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a != null) {
            User loggedUser = userService.findByUsername(((User)a.getPrincipal()).getUsername());
            return loggedUser.getContacts().stream().map(c -> new DataUser(c.getContact().getId(), c.getContact().getUsername(), c.getContact().getCoordinates(), c.getPictureUpdated())).collect(Collectors.toSet());
        }
        return new HashSet<>();
    }

    @PostMapping("/lastLocalization")
    public void lastLocalization(@RequestBody Coordinates coordinates) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a != null) {
            User loggedUser = userService.findByUsername(((User)a.getPrincipal()).getUsername());
            loggedUser.setCoordinates(coordinates);
            loggedUser.setLastUpdated(new Date());
            userService.save(loggedUser);
        }
    }
}
