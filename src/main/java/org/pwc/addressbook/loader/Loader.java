package org.pwc.addressbook.loader;

import org.pwc.addressbook.model.AddressBook;
import org.pwc.addressbook.model.Friend;
import org.pwc.addressbook.model.PhoneNumber;
import org.pwc.addressbook.repository.AddressBookRepository;
import org.pwc.addressbook.repository.FriendRepository;
import org.pwc.addressbook.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class Loader {

    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @PostConstruct
    public void load() {
        List<AddressBook> bookList = getAddressBooks();

        bookList.stream().forEach(book -> {
            book.getFriendList().stream().forEach(friend -> {
                phoneNumberRepository.saveAll(friend.getNumberList());
            });

            friendRepository.saveAll(book.getFriendList());
        });
        addressBookRepository.saveAll(bookList);

    }

    private List<AddressBook> getAddressBooks() {

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        List<Friend> friends;
        List<AddressBook> addressBooks = new ArrayList<>();

        PhoneNumber number;
        Friend friend1, friend2 ;
        AddressBook book;

        for (int i = 0; i < 3; i++) {
            number = PhoneNumber.builder().phoneNumber(generatePhoneNumber()).build();
            phoneNumbers.add(number);
        }

        friend1 = Friend.builder().friendName("Adam").numberList(phoneNumbers).build();
        friend2 = Friend.builder().friendName("David").numberList(phoneNumbers).build();
        friends = Arrays.asList(friend1, friend2);


        for (int i = 1; i < 5; i++) {

            book = AddressBook.builder().addressBookId(i).addressBookName("Book "+i).friendList(friends).build();
            addressBooks.add(book);
        }

        return addressBooks;
    }

    private String generatePhoneNumber() {
        Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        return phoneNumber;
    }

}
