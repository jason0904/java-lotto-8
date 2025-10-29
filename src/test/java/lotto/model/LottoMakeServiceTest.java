package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import lotto.validation.LottoRule;

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
        int count = 5;
        LottoRepository lottoRepository = lottoMakeService.makeLottos(count);

        assertEquals(lottoRepository.getLottos().size(), count);

        for (Lotto lotto : lottoRepository.getLottos()) {
            assertEquals(lotto.getNumbers().size(), 6);

            assertThat(lotto.getNumbers().stream()
            .allMatch(n -> n >= LottoRule.MIN_NUMBER.getValue() && n <= LottoRule.MAX_NUMBER.getValue()))
            .isTrue();

            assertThat(lotto.getNumbers()).isSorted();
        }

    }
}