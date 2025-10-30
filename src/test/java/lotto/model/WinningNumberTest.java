package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.config.LottoRule;
import lotto.validation.ErrorMessage;

public class WinningNumberTest {
    
    @Test
    @DisplayName("당첨번호가 6개가 아닐때 예외 발생 테스트")
    void validateLottoSize() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(java.util.Arrays.asList("1", "2", "3", "4", "5"));
        });

        assertEquals(ErrorMessage.WINNING_NUMBER_SIZE.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("당첨번호가 정수가 아닐때 예외 발생 테스트")
    @ValueSource(strings = {"a", "!", "3.5", " "})
    void validateNumberIsInteger(String invalidInput) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(java.util.Arrays.asList("1", "2", "3", "4", "5", invalidInput));
        });

        assertEquals(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호가 범위를 벗어났을때 예외 발생 테스트")
    void validateWinningNumberRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(java.util.Arrays.asList("1", "2", "3", "4", "5", String.valueOf(LottoRule.MAX_NUMBER.getValue() + 1)));
        });

        assertEquals(ErrorMessage.WINNING_NUMBER_RANGE.getMessage(), exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(java.util.Arrays.asList("0", "2", "3", "4", "5", String.valueOf(LottoRule.MIN_NUMBER.getValue() - 1)));
        });

        assertEquals(ErrorMessage.WINNING_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호에 중복된 숫자가 있을때 예외 발생 테스트")
    void validateDuplicateWinningNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(java.util.Arrays.asList("1", "2", "3", "4", "5", "5"));
        });

        assertEquals(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage(), exception.getMessage());
    }

}
