package org.pwc.addressbook.controller;

import org.pwc.addressbook.cache.AddressBookCache;
import org.pwc.addressbook.model.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/addressbook")
public class AddressbookController {

    @Autowired
    AddressBookCache addressBookCache;

    @GetMapping(path = "/friends")
    public List<AddressBook> getFriends() {
        return addressBookCache.getAllFriendsData();
    }
}
