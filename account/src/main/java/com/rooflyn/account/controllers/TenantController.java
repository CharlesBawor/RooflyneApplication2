package com.rooflyn.account.controllers;


import com.rooflyn.account.dtos.request.TenantRequestDto;
import com.rooflyn.account.dtos.response.ApiResponse;
import com.rooflyn.account.dtos.response.UserResponseDto;
import com.rooflyn.account.services.TenantService;
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
@RequestMapping(path = "/tenant", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Tenant",description = "Api for managing Tenant services")
@Validated
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<UserResponseDto>> createTenant(@Valid @RequestBody TenantRequestDto tenantRequestDto){
        ApiResponse<UserResponseDto> apiResponse = tenantService.createTenant(tenantRequestDto);
        return ResponseEntity.ok(apiResponse);
    }
}
