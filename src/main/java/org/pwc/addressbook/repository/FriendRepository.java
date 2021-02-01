package org.pwc.addressbook.repository;

import org.pwc.addressbook.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {

//    @Query("SELECT t FROM Friend t WHERE t.address_book_id = ?1")
//    List<Friend> findFriendByAddressBookId(int addressBookId);
}
