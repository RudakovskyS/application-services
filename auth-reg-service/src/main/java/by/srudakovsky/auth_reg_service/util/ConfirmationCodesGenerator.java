package by.srudakovsky.auth_reg_service.util;

import java.security.SecureRandom;

public class ConfirmationCodesGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_SYMBOLS = "!@#$%^&*()_+-=[]{}|;':,.<>/?";


    public static String generateConfirmationCode(int symbolsAmount, boolean lettersAllowed, boolean numbersAllowed, boolean specSymbolsAllowed) {
        StringBuilder allowedChars = new StringBuilder();
        if (lettersAllowed) {
            allowedChars.append(LETTERS);
        }
        if (numbersAllowed) {
            allowedChars.append(NUMBERS);
        }
        if (specSymbolsAllowed) {
            allowedChars.append(SPECIAL_SYMBOLS);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder confirmationCode = new StringBuilder(symbolsAmount);
        for (int i = 0; i < symbolsAmount; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            confirmationCode.append(allowedChars.charAt(randomIndex));
        }

        return confirmationCode.toString();
    }
}
