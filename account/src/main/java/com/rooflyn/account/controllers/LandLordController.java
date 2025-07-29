package com.rooflyn.account.controllers;

import com.rooflyn.account.dtos.request.LandLordRequestDto;
import com.rooflyn.account.dtos.response.ApiResponse;
import com.rooflyn.account.dtos.response.UserResponseDto;
import com.rooflyn.account.services.LandLordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/landlord", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "LandLord",description = "Api for managing Landlord services")
@Validated
public class LandLordController {

    private final LandLordService landLordService;

    @Autowired
    public LandLordController(LandLordService landLordService) {
        this.landLordService = landLordService;
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<UserResponseDto>> createLandLord(@Valid @RequestBody LandLordRequestDto landLordRequestDto){
       ApiResponse<UserResponseDto> apiResponse =  landLordService.createLandLord(landLordRequestDto);
        return ResponseEntity.ok(apiResponse);
    }
}
