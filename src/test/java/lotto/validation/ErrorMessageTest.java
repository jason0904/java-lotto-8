package lotto.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ErrorMessageTest {

    @Test
    @DisplayName("에러 메시지 형식 출력 테스트")
    void testErrorMessageFormat() {
        ErrorMessage errorMessage = ErrorMessage.PURCHASE_AMOUNT_UNIT;
        String expectedMessage = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
        assertEquals(expectedMessage, errorMessage.getMessage());
    }
    
}
