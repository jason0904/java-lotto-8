package lotto.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoNumberValidationTest {

    @Test
    @DisplayName("로또 번호 범위 검사 테스트")
    void testLottoNumberRange() {
        assertDoesNotThrow(() -> {
            LottoNumberValidation.validateNumberRange(LottoNumberValidation.MIN_NUMBER);
            LottoNumberValidation.validateNumberRange(LottoNumberValidation.MAX_NUMBER);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberValidation.validateNumberRange(LottoNumberValidation.MIN_NUMBER - 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberValidation.validateNumberRange(LottoNumberValidation.MAX_NUMBER + 1);
        });
    }

    @ParameterizedTest
    @CsvSource({
        "a",
        "10.5",
    })
    @DisplayName("로또번호 정수 검증 테스트")
    void testLottoNumberValidation(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumberValidation.validateNumberIsInteger(input);
        });

    }
}
