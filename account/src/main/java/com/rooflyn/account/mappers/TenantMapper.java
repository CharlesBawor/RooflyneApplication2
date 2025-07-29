package com.rooflyn.account.mappers;

import com.rooflyn.account.dtos.request.TenantRequestDto;
import com.rooflyn.account.models.Tenant;

public class TenantMapper {

    public static Tenant toTenant(TenantRequestDto tenantRequestDto){

        Tenant tenant = new Tenant();

        tenant.setFirstName(tenantRequestDto.getFirstNameRequestDto());
        tenant.setLastName(tenantRequestDto.getLastNameRequestDto());
        tenant.setUsername(tenantRequestDto.getUsernameRequestDto());
        tenant.setEmail(tenantRequestDto.getEmailRequestDto());
        tenant.setPassword(tenantRequestDto.getPasswordRequestDto());
        tenant.setPhoneNumber(tenantRequestDto.getPhoneNumberRequestDto());
        tenant.setDateOfBirth(tenantRequestDto.getDateOfBirthRequestDto());
        tenant.setProfileImageUrl(tenantRequestDto.getProfileImageUrlRequestDto());

        return tenant;
    }
}
