package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.config.WinningCondition;

public class WinningRepositoryTest {

    @Test
    @DisplayName("WinningRepository 초기상태 테스트")
    void testWinningRepository() {
        WinningRepository winningRepository = new WinningRepository();

        for (WinningCondition condition : WinningCondition.values()) {
            assertEquals(winningRepository.getCount(condition), 0L);
        }
    }

    @Test
    @DisplayName("WinningRepository 당첨기록 추가 테스트")
    void testAddCount() {
        WinningRepository winningRepository = new WinningRepository();
        assertEquals(winningRepository.getCount(WinningCondition.FIRST), 0L);

        winningRepository.addCount(WinningCondition.FIRST);
        assertEquals(winningRepository.getCount(WinningCondition.FIRST), 1L);
    }

    @Test
    @DisplayName("WinningRepository 총 수익률 계산 테스트")
    void testCalculateTotalProfitRate() {
        WinningRepository winningRepository = new WinningRepository();
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000");
        winningRepository.addCount(WinningCondition.FIRST); // 2,000,000,000원
        double profitRate = winningRepository.calculateTotalProfitRate(purchaseAmount);

        assertEquals(profitRate, WinningCondition.FIRST.getPrize() / purchaseAmount.getPurchaseAmount() * 100);

    }

}