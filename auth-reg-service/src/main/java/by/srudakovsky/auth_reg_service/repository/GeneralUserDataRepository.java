package by.srudakovsky.auth_reg_service.repository;

import by.srudakovsky.auth_reg_service.model.GeneralUserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralUserDataRepository extends JpaRepository<GeneralUserData, Integer> {
}
