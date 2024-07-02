package by.srudakovsky.auth_reg_service.repository;

import by.srudakovsky.auth_reg_service.model.GeneralUserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface GeneralUserDataRepository extends JpaRepository<GeneralUserData, UUID> {
    @Transactional
    @Modifying
    @Query("update GeneralUserData g set g.phoneNumber = ?1 where g.username = ?2")
    int updatePhoneNumberByUsername(@NonNull String phoneNumber, String username);

    GeneralUserData findByUsername(String username);
}
