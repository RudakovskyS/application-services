package by.srudakovsky.auth_reg_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "general_user_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralUserData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "phone_verified")
    private boolean phoneVerified;
    @Column(name = "email")
    private String email;
    @Column(name = "mail_verified")
    private boolean mailVerified;
    @Column(name = "preferred_auth_type")
    private String preferredAuthType;
}
