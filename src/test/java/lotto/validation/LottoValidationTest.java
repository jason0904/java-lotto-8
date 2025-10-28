package lotto.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoValidationTest {

    @Test
    @DisplayName("로또 번호 개수 검증 테스트")
    void testLottoSizeValidation() {
        assertDoesNotThrow(() -> {
            LottoValidation.validateLottoSize(6);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LottoValidation.validateLottoSize(5);
        });

    }
    
}
