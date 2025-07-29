package com.rooflyn.account.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rooflyn.account.annotations.MinAge;
import com.rooflyn.account.annotations.NoBadWords;
import com.rooflyn.account.annotations.NoMultipleEmail;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

public class UserRequestDto {


    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Firstname must be 3 - 20 characters long")
    @Pattern(
            regexp = "^[a-zA-Z]+$",
            message = "Username must contain only letters (no number or special characters)"
    )
    @NoBadWords(message = "Inappropriate word detected")
    private String usernameRequestDto;


    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Invalid email format")
    @NoMultipleEmail(message = "Multiple emails are not allowed")
    @NoBadWords(message = "Inappropriate word detected")
    private String emailRequestDto;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String passwordRequestDto;

    @Pattern(
            regexp = "^\\+[0-9]{10,15}$",
            message = "Phone number must start with '+' and contain only digits (10 to 15 digits)"
    )
    @NotBlank(message = "phone number is required")
    private String phoneNumberRequestDto;


    @NotNull(message = "Date of birth is required")
    @MinAge(value = 16,message = "You must be 16 or above")
    @JsonFormat(pattern = "yyyy-MM-dd") // For JSON deserialization
    private LocalDate dateOfBirthRequestDto;

    @URL(message = "Invalid image URL")
    private String profileImageUrlRequestDto;

    //Constructor

    public UserRequestDto(String usernameRequestDto, String emailRequestDto, String passwordRequestDto, String phoneNumberRequestDto,
                          LocalDate dateOfBirthRequestDto, String profileImageUrlRequestDto) {
        this.usernameRequestDto = usernameRequestDto;
        this.emailRequestDto = emailRequestDto;
        this.passwordRequestDto = passwordRequestDto;
        this.phoneNumberRequestDto = phoneNumberRequestDto;
        this.dateOfBirthRequestDto = dateOfBirthRequestDto;
        this.profileImageUrlRequestDto = profileImageUrlRequestDto;
    }

    public UserRequestDto() {

    }

    //Getters and Setters


    public String getUsernameRequestDto() {
        return usernameRequestDto;
    }

    public void setUsernameRequestDto(String usernameRequestDto) {
        this.usernameRequestDto = usernameRequestDto;
    }

    public String getEmailRequestDto() {
        return emailRequestDto;
    }

    public void setEmailRequestDto(String emailRequestDto) {
        this.emailRequestDto = emailRequestDto;
    }

    public String getPasswordRequestDto() {
        return passwordRequestDto;
    }

    public void setPasswordRequestDto(String passwordRequestDto) {
        this.passwordRequestDto = passwordRequestDto;
    }

    public String getPhoneNumberRequestDto() {
        return phoneNumberRequestDto;
    }

    public void setPhoneNumberRequestDto(String phoneNumberRequestDto) {
        this.phoneNumberRequestDto = phoneNumberRequestDto;
    }

    public LocalDate getDateOfBirthRequestDto() {
        return dateOfBirthRequestDto;
    }

    public void setDateOfBirthRequestDto(LocalDate dateOfBirthRequestDto) {
        this.dateOfBirthRequestDto = dateOfBirthRequestDto;
    }

    public String getProfileImageUrlRequestDto() {
        return profileImageUrlRequestDto;
    }

    public void setProfileImageUrlRequestDto(String profileImageUrlRequestDto) {
        this.profileImageUrlRequestDto = profileImageUrlRequestDto;
    }
}
