package com.rooflyn.account.models.enums;

public enum UserStatus {
    ACTIVE,          // User is active and can access the system
    INACTIVE,        // User registered but not yet activated
    SUSPENDED,       // Temporarily blocked (e.g., due to unpaid rent or violations)
    DEACTIVATED,     // User has been manually deactivated (e.g., by admin)
    PENDING_APPROVAL,// Awaiting admin approval (e.g., after registration)
    BANNED,          // Permanently banned
    VERIFIED,        // Email/KYC verified
    UNVERIFIED       // Awaiting verification
}
