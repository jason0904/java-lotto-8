package lotto.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRuleTest {
    
    @Test
    @DisplayName("LottoRule enum 값 테스트")
    void testLottoRuleValues() {
        assertEquals(6, LottoRule.SIZE.getValue());
        assertEquals(1, LottoRule.MIN_NUMBER.getValue());
        assertEquals(45, LottoRule.MAX_NUMBER.getValue());
        assertEquals(1000, LottoRule.PURCHASE_UNIT.getValue());
    }
}
