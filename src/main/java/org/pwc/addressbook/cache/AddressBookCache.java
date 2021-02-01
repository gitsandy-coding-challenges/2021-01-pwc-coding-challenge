package org.pwc.addressbook.cache;

import org.pwc.addressbook.model.AddressBook;
import org.pwc.addressbook.repository.AddressBookRepository;
import org.pwc.addressbook.repository.FriendRepository;
import org.pwc.addressbook.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressBookCache {

    @Autowired
    AddressBookRepository addressBookRepository;


    @Autowired
    FriendRepository friendRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;


    @Cacheable(value = "addressBookCache")
    public List<AddressBook> getAllFriendsData() {

        List<AddressBook> addressBooks = addressBookRepository.findAll();

        return addressBooks;
    }
}
