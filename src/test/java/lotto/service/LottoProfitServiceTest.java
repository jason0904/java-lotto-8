package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.config.WinningCondition;
import lotto.model.PurchaseAmount;
import lotto.model.WinningRepository;

public class LottoProfitServiceTest {

    @Test
    @DisplayName("로또 수익률 계산 테스트")
    void testCalculateProfitRate() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("10000");
        WinningRepository winningRepository = new WinningRepository();
        winningRepository.addCount(WinningCondition.FIRST);
        winningRepository.addCount(WinningCondition.THIRD);
        LottoProfitService lottoProfitService = new LottoProfitService();
        double profitRate = lottoProfitService.calculateProfitRate(purchaseAmount, winningRepository);
        double expectedProfitRate = ((WinningCondition.FIRST.getPrize() + WinningCondition.THIRD.getPrize())
                / purchaseAmount.getPurchaseAmount()) * 100;

        assertEquals(expectedProfitRate, profitRate);
    }

}
