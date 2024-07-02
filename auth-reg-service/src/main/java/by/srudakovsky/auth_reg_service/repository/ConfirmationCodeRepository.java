package by.srudakovsky.auth_reg_service.repository;

import by.srudakovsky.auth_reg_service.model.ConfirmationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, UUID> {
}
