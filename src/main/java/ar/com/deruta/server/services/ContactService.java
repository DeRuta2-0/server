package ar.com.deruta.server.services;

import ar.com.deruta.server.models.Contact;
import ar.com.deruta.server.models.Place;
import ar.com.deruta.server.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

}
