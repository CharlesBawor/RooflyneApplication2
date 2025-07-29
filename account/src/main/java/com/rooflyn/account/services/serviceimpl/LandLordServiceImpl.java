package com.rooflyn.account.services.serviceimpl;

import com.rooflyn.account.constants.ResponseConstant;
import com.rooflyn.account.dtos.request.LandLordRequestDto;
import com.rooflyn.account.dtos.response.ApiResponse;
import com.rooflyn.account.dtos.response.UserResponseDto;
import com.rooflyn.account.exceptions.EmailAlreadyExistException;
import com.rooflyn.account.mappers.LandLordMapper;
import com.rooflyn.account.mappers.UserMapper;
import com.rooflyn.account.models.LandLord;
import com.rooflyn.account.repositories.LandLordRepository;
import com.rooflyn.account.services.LandLordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LandLordServiceImpl implements LandLordService {

    private static final Logger logger = LoggerFactory.getLogger(LandLordServiceImpl.class);

    private final LandLordRepository landLordRepository;

    @Autowired
    public LandLordServiceImpl(LandLordRepository landLordRepository) {
        this.landLordRepository = landLordRepository;
    }

    @Transactional
    @Override
    public ApiResponse<UserResponseDto> createLandLord(LandLordRequestDto landLordRequestDto) {

        String email = landLordRequestDto.getEmailRequestDto().trim().toLowerCase();

        if (landLordRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistException("Email already exist: " + email);
        }

        LandLord landLord = landLordRepository.save(LandLordMapper.toLandLord(landLordRequestDto));

        logger.info("Landlord created with ID: {}", landLord.getId());

        return new ApiResponse<>(ResponseConstant.ResponseStatus.CREATED_201.getCode(),
                ResponseConstant.ResponseStatus.CREATED_201.getMessage(),
                UserMapper.userResponseDto(landLord));

    }
}
