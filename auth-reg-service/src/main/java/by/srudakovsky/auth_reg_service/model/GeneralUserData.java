package by.srudakovsky.auth_reg_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "general_user_data")
@Getter
@Setter
public class GeneralUserData {
    @Id
    @Column(name = "user_id")
    private int userId;
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
