package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRepositoryTest {

    @Test
    @DisplayName("LottoRepository 값 저장 테스트") 
    void testLottoRepository() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(7,8,9,10,11,12));
        LottoRepository lottoRepository = new LottoRepository(List.of(lotto1, lotto2));

        assertEquals(2, lottoRepository.getLottos().size());

        assertEquals(List.of(1,2,3,4,5,6), lottoRepository.getLottos().get(0).getNumbers());
        assertEquals(List.of(7,8,9,10,11,12), lottoRepository.getLottos().get(1).getNumbers());
    }
}
