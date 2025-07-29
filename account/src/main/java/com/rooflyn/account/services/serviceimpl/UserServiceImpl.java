package com.rooflyn.account.services.serviceimpl;

import com.rooflyn.account.dtos.response.ApiResponse;
import com.rooflyn.account.dtos.response.UserResponseDto;
import com.rooflyn.account.exceptions.EmailAlreadyExistException;
import com.rooflyn.account.repositories.UserRepository;
import com.rooflyn.account.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse<UserResponseDto> updateUsers(UserResponseDto userResponseDto, UUID userId){
        if (userRepository.existsByEmailAndIdNot(userResponseDto.getEmailResponseDto(),userId)){
            throw new EmailAlreadyExistException("User with this email already exist: " + userResponseDto.getEmailResponseDto());
        }
            return null;
    }
}
