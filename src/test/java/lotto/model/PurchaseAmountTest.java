package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.validation.ErrorMessage;

public class PurchaseAmountTest {
    
    @Test
    @DisplayName("구입 금액 생성 테스트")
    void testPurchaseAmountCreation() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("5000");
        assertEquals(purchaseAmount.getPurchaseAmount(), 5000L);
    }

    @Test
    @DisplayName("금액이 음수일때 예외 발생 테스트")
    void testPurchaseAmountValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount("-1000");
        });

        assertEquals(ErrorMessage.ERROR_PURCHASE_AMOUNT_POSITIVE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("금액이 0원일때 예외 발생 테스트")
    void testPurchaseAmountZeroValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount("0");
        });

        assertEquals(ErrorMessage.ERROR_PURCHASE_AMOUNT_ZERO.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아닐때 예외 발생 테스트")
    void testPurchaseAmountUnitValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount("1500");
        });

        assertEquals(ErrorMessage.ERROR_PURCHASE_AMOUNT_UNIT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("금액이 Long 최대값을 초과할때 예외 발생 테스트")
    void testPurchaseAmountMaxValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount("9223372036854775808"); // Long.MAX_VALUE + 1을 문자열로 표현
        });

        assertEquals(ErrorMessage.ERROR_PURCHASE_AMOUNT_MAX.getMessage(), exception.getMessage());
    }

}
