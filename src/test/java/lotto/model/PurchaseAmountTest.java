package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

        assertEquals(ErrorMessage.PURCHASE_AMOUNT_POSITIVE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("금액이 0원일때 예외 발생 테스트")
    void testPurchaseAmountZeroValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount("0");
        });

        assertEquals(ErrorMessage.PURCHASE_AMOUNT_ZERO.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아닐때 예외 발생 테스트")
    void testPurchaseAmountUnitValidation() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount("1500");
        });

        assertEquals(ErrorMessage.PURCHASE_AMOUNT_UNIT.getMessage(), exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("금액이 정수가 아닐때 예외 발생 테스트")
    @ValueSource(strings = {"1000.5", "one000", "abc"})
    void testPurchaseAmountNotLongValidation(String invalidAmount) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseAmount(invalidAmount);
        });
        
        assertEquals(ErrorMessage.PURCHASE_AMOUNT_NOT_LONG.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 구매 갯수 계산 테스트")
    void testGetLottoCount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("5000");
        assertEquals(5, purchaseAmount.getLottoCount());
    }

}
