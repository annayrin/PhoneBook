package com.example.phonebook.service.impl;

import com.example.phonebook.model.Contact;
import com.example.phonebook.repository.ContactRepository;
import com.example.phonebook.service.ContactService;
import com.example.phonebook.util.Validation;
import com.example.phonebook.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        if (!Validator.doValidation(Validation.regexPhone, contact.getPhone())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Check phone input");
        }
        else if (!Validator.doValidation(Validation.regexEmail, contact.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Check email input");
        }
        else if (!Validator.checkLabel(contact.getEmailLable(),Validation.lable)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Check email label");
        }
        else if (!Validator.checkLabel(contact.getPhoneLable(),Validation.lable)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Check phone label");
        }
      else{
          return contactRepository.save(contact);
        }
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    @Transactional
    public Contact update(Contact contact, int id) {
        Contact fromDb = contactRepository.findById(id).orElseThrow(() -> {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong ");
        });
        fromDb.setName(contact.getName());
        fromDb.setSurname(contact.getSurname());
        fromDb.setPhone(contact.getPhone());
        fromDb.setPhoneLable(contact.getPhoneLable());
        fromDb.setEmail(contact.getEmail());
        fromDb.setEmailLable(contact.getEmailLable());
        return fromDb;
    }

    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> getByKey(String key) {
        return getAll()
                .stream()
                .filter(item -> item.stringify().toLowerCase(Locale.ROOT)
                        .contains(key.toLowerCase(Locale.ROOT))
                )
                .collect(Collectors
                        .toList()
                );

    }
}
