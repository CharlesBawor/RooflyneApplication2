package com.rooflyn.account.services.serviceimpl;

import com.rooflyn.account.constants.ResponseConstant;
import com.rooflyn.account.dtos.request.TenantRequestDto;
import com.rooflyn.account.dtos.response.ApiResponse;
import com.rooflyn.account.dtos.response.UserResponseDto;
import com.rooflyn.account.exceptions.EmailAlreadyExistException;
import com.rooflyn.account.mappers.TenantMapper;
import com.rooflyn.account.mappers.UserMapper;
import com.rooflyn.account.models.Tenant;
import com.rooflyn.account.repositories.TenantRepository;
import com.rooflyn.account.services.TenantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    private static final Logger logger = LoggerFactory.getLogger(TenantServiceImpl.class);

    @Autowired
    public TenantServiceImpl(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Transactional
    @Override
    public ApiResponse<UserResponseDto> createTenant(TenantRequestDto tenantRequestDto) {

        String email = tenantRequestDto.getEmailRequestDto().trim().toLowerCase();

        if (tenantRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistException("Email already exist: " + email);
        }

        Tenant tenant = tenantRepository.save(TenantMapper.toTenant(tenantRequestDto));

        logger.info("Landlord created with ID: {}", tenant.getId());

        return new ApiResponse<>(ResponseConstant.ResponseStatus.CREATED_201.getCode(),
                ResponseConstant.ResponseStatus.CREATED_201.getMessage(),
                UserMapper.userResponseDto(tenant));
    }
}
