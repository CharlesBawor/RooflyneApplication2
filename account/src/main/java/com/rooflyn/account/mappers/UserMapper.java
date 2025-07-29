package com.rooflyn.account.mappers;

import com.rooflyn.account.dtos.response.UserResponseDto;
import com.rooflyn.account.models.LandLord;
import com.rooflyn.account.models.Tenant;
import com.rooflyn.account.models.enums.UserStatus;

import java.util.Objects;

public class UserMapper {

    public static UserResponseDto userResponseDto(LandLord landLord){

        UserResponseDto userResponseDto = new UserResponseDto();

        if (Objects.equals(userResponseDto.getRoleResponseDto(), "LANDLORD")){
            userResponseDto.setUserIdResponseDto(landLord.getId().toString() + "L");
        }
        userResponseDto.setUsernameResponseDto(landLord.getUsername());
        userResponseDto.setEmailResponseDto(landLord.getEmail());
        userResponseDto.setPhoneNumberResponseDto(landLord.getPhoneNumber());
        userResponseDto.setRoleResponseDto(landLord.getROLE());
        userResponseDto.setProfileImageUrlResponseDto(landLord.getProfileImageUrl());

        if (!landLord.isEmailVerified()){
            landLord.setUserStatus(UserStatus.UNVERIFIED);
        }
        else landLord.setUserStatus(UserStatus.VERIFIED);

        userResponseDto.setUserStatusResponseDto(landLord.getUserStatus().toString());

        return userResponseDto;
    }


    public static UserResponseDto userResponseDto(Tenant tenant){

        UserResponseDto userResponseDto = new UserResponseDto();

        if (Objects.equals(userResponseDto.getRoleResponseDto(), "TENANT")){
            userResponseDto.setUserIdResponseDto(tenant.getId().toString() + "T");
        }

        userResponseDto.setUsernameResponseDto(tenant.getUsername());
        userResponseDto.setEmailResponseDto(tenant.getEmail());
        userResponseDto.setPhoneNumberResponseDto(tenant.getPhoneNumber());
        userResponseDto.setRoleResponseDto(tenant.getROLE());
        userResponseDto.setProfileImageUrlResponseDto(tenant.getProfileImageUrl());

        if (!tenant.isEmailVerified()){
            tenant.setUserStatus(UserStatus.UNVERIFIED);
        }
        else tenant.setUserStatus(UserStatus.VERIFIED);

        userResponseDto.setUserStatusResponseDto(tenant.getUserStatus().toString());

        return userResponseDto;
    }
}
