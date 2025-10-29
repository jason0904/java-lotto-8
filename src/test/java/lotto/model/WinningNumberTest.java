package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.validation.ErrorMessage;

public class WinningNumberTest {
    
    @Test
    @DisplayName("당첨번호가 6개가 아닐때 예외 발생 테스트")
    void validateLottoSize() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(java.util.Arrays.asList("1", "2", "3", "4", "5"));
        });

        assertEquals(ErrorMessage.WINNING_NUMBER_COUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호에 숫자가 아닌 값이 포함될때 예외 발생 테스트")
    void validateNumberIsInteger() {

}
