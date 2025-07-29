package com.rooflyn.account.dtos.response;

public class UserResponseDto {

    private String userIdResponseDto;

    private String usernameResponseDto;

    private String emailResponseDto;

    private String phoneNumberResponseDto;

    private String roleResponseDto;

    private String profileImageUrlResponseDto;

    private String userStatusResponseDto;

    //Constructor


    public UserResponseDto(String userIdResponseDto, String usernameResponseDto, String emailResponseDto,
                           String phoneNumberResponseDto, String roleResponseDto, String profileImageUrlResponseDto,
                           String userStatusResponseDto) {
        this.userIdResponseDto = userIdResponseDto;
        this.usernameResponseDto = usernameResponseDto;
        this.emailResponseDto = emailResponseDto;
        this.phoneNumberResponseDto = phoneNumberResponseDto;
        this.roleResponseDto = roleResponseDto;
        this.profileImageUrlResponseDto = profileImageUrlResponseDto;
        this.userStatusResponseDto = userStatusResponseDto;
    }

    public UserResponseDto() {

    }

    //Getters and Setters


    public String getUserIdResponseDto() {
        return userIdResponseDto;
    }

    public void setUserIdResponseDto(String userIdResponseDto) {
        this.userIdResponseDto = userIdResponseDto;
    }

    public String getUsernameResponseDto() {
        return usernameResponseDto;
    }

    public void setUsernameResponseDto(String usernameResponseDto) {
        this.usernameResponseDto = usernameResponseDto;
    }

    public String getEmailResponseDto() {
        return emailResponseDto;
    }

    public void setEmailResponseDto(String emailResponseDto) {
        this.emailResponseDto = emailResponseDto;
    }

    public String getPhoneNumberResponseDto() {
        return phoneNumberResponseDto;
    }

    public void setPhoneNumberResponseDto(String phoneNumberResponseDto) {
        this.phoneNumberResponseDto = phoneNumberResponseDto;
    }

    public String getRoleResponseDto() {
        return roleResponseDto;
    }

    public void setRoleResponseDto(String roleResponseDto) {
        this.roleResponseDto = roleResponseDto;
    }

    public String getProfileImageUrlResponseDto() {
        return profileImageUrlResponseDto;
    }

    public void setProfileImageUrlResponseDto(String profileImageUrlResponseDto) {
        this.profileImageUrlResponseDto = profileImageUrlResponseDto;
    }

    public String getUserStatusResponseDto() {
        return userStatusResponseDto;
    }

    public void setUserStatusResponseDto(String userStatusResponseDto) {
        this.userStatusResponseDto = userStatusResponseDto;
    }
}
