package com.rooflyn.account.services;

import com.rooflyn.account.dtos.request.TenantRequestDto;
import com.rooflyn.account.dtos.response.ApiResponse;
import com.rooflyn.account.dtos.response.UserResponseDto;

public interface TenantService {
    public ApiResponse<UserResponseDto> createTenant(TenantRequestDto tenantRequestDto);
}
