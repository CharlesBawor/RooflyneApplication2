package com.rooflyn.account.services;

import com.rooflyn.account.dtos.request.LandLordRequestDto;
import com.rooflyn.account.dtos.response.ApiResponse;
import com.rooflyn.account.dtos.response.UserResponseDto;

public interface LandLordService {

    public ApiResponse<UserResponseDto> createLandLord(LandLordRequestDto landLordRequestDto);
}
