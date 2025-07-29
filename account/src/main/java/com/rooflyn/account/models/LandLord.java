package com.rooflyn.account.models;

import com.rooflyn.account.models.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("LANDLORD")
public class LandLord extends User{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    // Constructor

    public LandLord(String username, String email, String password, String phoneNumber,
                    LocalDate dateOfBirth, UserStatus userStatus, boolean emailVerified,
                    String profileImageUrl, String firstName, String lastName) {
        super(username, email, password, phoneNumber, dateOfBirth, userStatus, emailVerified, profileImageUrl);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public LandLord() {
        super();
    }


    // Getters and Setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getROLE() {
        return "LANDLORD";
    }
}
