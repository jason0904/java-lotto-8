package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.config.LottoRule;
import lotto.validation.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호 범위 예외 발생 테스트")
    void bonusNumberOutOfRange() {
        WinningNumber winningNumber = new WinningNumber(List.of("1", "2", "3", "4", "5", "6"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(String.valueOf(LottoRule.MAX_NUMBER.getValue() + 1), winningNumber);
        });

        assertEquals(ErrorMessage.INVALID_NUMBER_RANGE.getMessage(), exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(String.valueOf(LottoRule.MIN_NUMBER.getValue() - 1), winningNumber);
        });

        assertEquals(ErrorMessage.INVALID_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복 예외 발생 테스트")
    void bonusNumberDuplicateWithWinningNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of("1", "2", "3", "4", "5", "6"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber("3", winningNumber);
        });

        assertEquals(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "A", "!", "3.5", " " })
    @DisplayName("보너스 번호의 입력이 정수형식이 아닐 경우 예외 발생 테스트")
    void bonusNumberNotIntegerFormat(String invalidInput) {
        WinningNumber winningNumber = new WinningNumber(List.of("1", "2", "3", "4", "5", "6"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(invalidInput, winningNumber);
        });

        assertEquals(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage(), exception.getMessage());
    }
}
