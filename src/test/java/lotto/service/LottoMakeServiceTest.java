package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import lotto.config.LottoRule;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.model.PurchaseAmount;

import org.junit.jupiter.api.DisplayName;

public class LottoMakeServiceTest {
    
    @Test
    @DisplayName("로또 생성 서비스 테스트")
    void testLottoMakeService() {
        LottoMakeService lottoMakeService = new LottoMakeService();
        Lotto lotto = lottoMakeService.makeLotto();
        
        assertEquals(lotto.getNumbers().size(), 6);

        assertThat(lotto.getNumbers().stream()
        .allMatch(n -> n >= LottoRule.MIN_NUMBER.getValue() && n <= LottoRule.MAX_NUMBER.getValue()))
        .isTrue();

        assertThat(lotto.getNumbers()).isSorted();
    }

    @Test
    @DisplayName("로또 여러장 생성 서비스 테스트")
    void testLottoMakeMultipleService() {
        LottoMakeService lottoMakeService = new LottoMakeService();
        PurchaseAmount purchaseAmount = new PurchaseAmount("5000");
        LottoRepository lottoRepository = lottoMakeService.makeLottos(purchaseAmount);

        assertEquals(lottoRepository.getLottos().size(), purchaseAmount.getPurchaseAmount() / LottoRule.PURCHASE_UNIT.getValue());

        for (Lotto lotto : lottoRepository.getLottos()) {
            assertEquals(lotto.getNumbers().size(), 6);

            assertThat(lotto.getNumbers().stream()
            .allMatch(n -> n >= LottoRule.MIN_NUMBER.getValue() && n <= LottoRule.MAX_NUMBER.getValue()))
            .isTrue();

            assertThat(lotto.getNumbers()).isSorted();
        }

    }
}