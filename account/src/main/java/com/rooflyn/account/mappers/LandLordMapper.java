package com.rooflyn.account.mappers;

import com.rooflyn.account.dtos.request.LandLordRequestDto;
import com.rooflyn.account.models.LandLord;

public class LandLordMapper {

    public static LandLord toLandLord(LandLordRequestDto landLordRequestDto){

        LandLord landLord = new LandLord();

        landLord.setFirstName(landLordRequestDto.getFirstNameRequestDto());
        landLord.setLastName(landLordRequestDto.getLastNameRequestDto());
        landLord.setUsername(landLordRequestDto.getUsernameRequestDto());
        landLord.setEmail(landLordRequestDto.getEmailRequestDto());
        landLord.setPassword(landLordRequestDto.getPasswordRequestDto());
        landLord.setPhoneNumber(landLordRequestDto.getPhoneNumberRequestDto());
        landLord.setDateOfBirth(landLordRequestDto.getDateOfBirthRequestDto());
        landLord.setProfileImageUrl(landLordRequestDto.getProfileImageUrlRequestDto());

        return landLord;
    }
}
