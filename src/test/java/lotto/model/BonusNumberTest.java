package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import lotto.validation.ErrorMessage;
import lotto.validation.LottoRule;

import java.util.List;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호 범위 예외 발생 테스트")
    void bonusNumberOutOfRange() {
        WinningNumber winningNumber = new WinningNumber(List.of("1", "2", "3", "4", "5", "6"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(LottoRule.MAX_NUMBER.getValue() + 1, winningNumber);
        });

        assertEquals(ErrorMessage.WINNING_NUMBER_RANGE.getMessage(), exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(LottoRule.MIN_NUMBER.getValue() - 1, winningNumber);
        });

        assertEquals(ErrorMessage.WINNING_NUMBER_RANGE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복 예외 발생 테스트")
    void bonusNumberDuplicateWithWinningNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of("1", "2", "3", "4", "5", "6"));
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BonusNumber(3, winningNumber);
        });
        
        assertEquals(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage(), exception.getMessage());
    }
}
