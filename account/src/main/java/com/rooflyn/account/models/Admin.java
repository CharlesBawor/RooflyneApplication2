package com.rooflyn.account.models;

import com.rooflyn.account.models.enums.AdminRole;
import com.rooflyn.account.models.enums.UserStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID adminId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private AdminRole adminRole;

    private UserStatus userStatus;

    private boolean emailVerified;

    private boolean isSuperAdmin;

    private boolean canSuspendAccount;

    private boolean canBeSuspended;

    private boolean isActive;

    private LocalDateTime lastLogin;

    private String lastAction;

    private String lastActionTime;

    private String profileImageUrl;
}
