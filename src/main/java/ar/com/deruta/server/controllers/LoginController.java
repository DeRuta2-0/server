package ar.com.deruta.server.controllers;

import ar.com.deruta.server.models.User;
import ar.com.deruta.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping
    public void login (@RequestBody User user) throws Exception {
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
            if (userDetails != null && encoder.matches(user.getPassword(), userDetails.getPassword())) {
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
                System.out.println("Logged user: " + user.getUsername());
            } else throw new Exception();
        } else throw new Exception();
    }

    @GetMapping
    public void ping () throws Exception {
        System.out.println("PONG");
    }
}
