package org.pwc.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Friend implements Serializable {


    private static final long serialVersionUID = 6114555643496525958L;

    @Id
    @Column(name = "friend_id", nullable = false)
    private int friendId;

    private String friendName;

    @ManyToOne
    @JoinColumn(name="address_book_id")
    private AddressBook addressBook;

    @OneToMany(mappedBy = "friend")
    private List<PhoneNumber> numberList;
}
