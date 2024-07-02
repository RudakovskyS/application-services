package by.srudakovsky.auth_reg_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "confirmation_codes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "code_id")
    private UUID codeId;
    @Column(name = "code_type")
    private String codeType;
    @Column(name = "confirmation_target")
    private String confirmationTarget;
    @Column(name = "code")
    private String code;
    @Column(name = "active")
    private boolean active;
    @Column(name = "confirmed")
    private boolean confirmed;
    @Column(name = "ts_inserted")
    private LocalDateTime tsInserted;
    @Column(name = "ts_confirmed")
    private LocalDateTime tsConfirmed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private GeneralUserData generalUserData;
}
