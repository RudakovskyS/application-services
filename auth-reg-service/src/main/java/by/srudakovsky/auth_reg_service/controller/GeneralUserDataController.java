package by.srudakovsky.auth_reg_service.controller;

import by.srudakovsky.auth_reg_service.dto.request.PhoneNumberDto;
import by.srudakovsky.auth_reg_service.dto.request.RegistrationDto;
import by.srudakovsky.auth_reg_service.model.GeneralUserData;
import by.srudakovsky.auth_reg_service.service.GeneralUserDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
public class GeneralUserDataController {
    private final GeneralUserDataService generalUserDataService;

    public GeneralUserDataController(GeneralUserDataService generalUserDataService) {
        this.generalUserDataService = generalUserDataService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<GeneralUserData>> displayUsersData() {
        return null;
//        return ResponseEntity.status(HttpStatus.OK).body(generalUserDataService.getUsersList());
    }

    @PostMapping("/register")
    public ResponseEntity<GeneralUserData> registerUser(@RequestBody RegistrationDto registrationDto) {
        return ResponseEntity.status(HttpStatus.OK).body(generalUserDataService.registerUser(registrationDto));
    }

    @PutMapping("/{username}/add-phone")
    public ResponseEntity<String> addPhone(@PathVariable String username, @RequestBody PhoneNumberDto phoneNumberDto) {
        generalUserDataService.updatePhoneNumber(phoneNumberDto.getPhoneNumber(), username);
        return ResponseEntity.status(HttpStatus.OK).body("Phone number is updated!");
    }
}
