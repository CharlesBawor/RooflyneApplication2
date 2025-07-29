package com.rooflyn.account.dtos.request;

import com.rooflyn.account.annotations.NoBadWords;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TenantRequestDto extends UserRequestDto{


    @NotBlank(message = "Firstname is required")
    @Size(min = 3, max = 20, message = "Firstname must be 3 - 20 characters long")
    @Pattern(
            regexp = "^[a-zA-Z]+$",
            message = "Firstname must contain only letters (no number or special characters)"
    )
    @NoBadWords(message = "Inappropriate word detected")
    private String firstNameRequestDto;


    @NotBlank(message = "Lastname is required")
    @Size(min = 3, max = 20, message = "Firstname must be 3 - 20 characters long")
    @Pattern(
            regexp = "^[a-zA-Z]+$",
            message = "Lastname must contain only letters (no number or special characters)"
    )
    @NoBadWords(message = "Inappropriate word detected")
    private String lastNameRequestDto;

    //Constructor

    public TenantRequestDto(String usernameRequestDto, String emailRequestDto, String passwordRequestDto, String phoneNumberRequestDto, LocalDate dateOfBirthRequestDto, String profileImageUrlRequestDto) {
        super(usernameRequestDto, emailRequestDto, passwordRequestDto, phoneNumberRequestDto, dateOfBirthRequestDto, profileImageUrlRequestDto);
    }

    //Getters and Setters


    public String getFirstNameRequestDto() {
        return firstNameRequestDto;
    }

    public void setFirstNameRequestDto(String firstNameRequestDto) {
        this.firstNameRequestDto = firstNameRequestDto;
    }

    public String getLastNameRequestDto() {
        return lastNameRequestDto;
    }

    public void setLastNameRequestDto(String lastNameRequestDto) {
        this.lastNameRequestDto = lastNameRequestDto;
    }
}
