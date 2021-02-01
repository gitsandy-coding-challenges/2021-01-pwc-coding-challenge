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
public class AddressBook implements Serializable {


    private static final long serialVersionUID = -6490023323498066899L;

    @Id
    @Column(name = "address_book_id", nullable = false)
    private int addressBookId;

    private String addressBookName;

    @OneToMany(mappedBy = "addressBook")
    private List<Friend> friendList;
}
