package org.pwc.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber implements Serializable {


    private static final long serialVersionUID = 3775338344020095617L;

    @Id
    @GeneratedValue
    @Column(name = "phone_number_id", nullable = false)
    private int phoneNumberId;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="friend_id")
    private Friend friend;

}
