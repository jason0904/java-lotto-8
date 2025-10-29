package lotto.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitStringValidationTest {
    
    @Test
    @DisplayName("입력 값이 쉼표(,)로 시작할 경우 예외 발생 테스트")
    void validateStringStartWithComma() {
        String input = ",1,2,3";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            SplitStringValidation.validateComma(input);
        });

        assertEquals(ErrorMessage.STRING_STARTS_WITH_COMMA.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("입력 값이 쉼표(,)로 끝날 경우 예외 발생 테스트")
    void validateStringEndWithComma() {
        String input = "1,2,3,";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            SplitStringValidation.validateComma(input);
        });
        
        assertEquals(ErrorMessage.STRING_ENDS_WITH_COMMA.getMessage(), exception.getMessage());
    }

}
