package by.srudakovsky.auth_reg_service.service;

import by.srudakovsky.auth_reg_service.model.GeneralUserData;
import by.srudakovsky.auth_reg_service.repository.GeneralUserDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralUserDataService {
    private final GeneralUserDataRepository generalUserDataRepository;

    public GeneralUserDataService(GeneralUserDataRepository generalUserDataRepository) {
        this.generalUserDataRepository = generalUserDataRepository;
    }

    public List<GeneralUserData> getUsersList() {

        return generalUserDataRepository.findAll();
    }

    @Scheduled(cron = "1 * * * * *")
    public void writeUsersData() {
        ObjectMapper objectMapper = new ObjectMapper();
        getUsersList().forEach(generalUserData -> {
            try {
                System.out.println(objectMapper.writeValueAsString(generalUserData));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
