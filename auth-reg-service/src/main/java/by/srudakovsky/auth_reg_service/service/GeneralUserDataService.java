package by.srudakovsky.auth_reg_service.service;

import by.srudakovsky.auth_reg_service.dto.request.RegistrationDto;
import by.srudakovsky.auth_reg_service.model.ConfirmationCode;
import by.srudakovsky.auth_reg_service.model.GeneralUserData;
import by.srudakovsky.auth_reg_service.repository.ConfirmationCodeRepository;
import by.srudakovsky.auth_reg_service.repository.GeneralUserDataRepository;
import by.srudakovsky.auth_reg_service.util.ConfirmationCodesGenerator;
import org.springframework.stereotype.Service;

@Service
public class GeneralUserDataService {
    private final GeneralUserDataRepository generalUserDataRepository;
    private final ConfirmationCodeRepository confirmationCodeRepository;

    public GeneralUserDataService(GeneralUserDataRepository generalUserDataRepository, ConfirmationCodeRepository confirmationCodeRepository) {
        this.generalUserDataRepository = generalUserDataRepository;
        this.confirmationCodeRepository = confirmationCodeRepository;
    }

    public GeneralUserData registerUser(RegistrationDto registrationDto) {
        return generalUserDataRepository.save(GeneralUserData.builder()
                .username(registrationDto.getUsername())
                .password(registrationDto.getPassword())
                .build());
    }

    public void updatePhoneNumber(String phoneNumber, String username) {
        int result = generalUserDataRepository.updatePhoneNumberByUsername(phoneNumber, username);
        if (result != 0) {
            confirmationCodeRepository.save(
                    ConfirmationCode.builder()
                            .generalUserData(generalUserDataRepository.findByUsername(username))
                            .code(ConfirmationCodesGenerator.generateConfirmationCode(6, false,
                                    true, false))
                            .confirmationTarget(phoneNumber)
                            .build()
            );
        }
    }
}
