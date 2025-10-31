package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import lotto.config.WinningCondition;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.model.WinningNumber;
import lotto.model.WinningRepository;

public class LotteryCheckServiceTest {

    @Test
    @DisplayName("당첨 기록 확인 테스트")
    void testLotteryCheckService() {
        LottoRepository lottoRepository = new LottoRepository(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 7, 8)), // 4등
                new Lotto(List.of(1, 2, 3, 7, 8, 9)), // 5등
                new Lotto(List.of(10, 11, 12, 13, 14, 15)) // 낙첨
        ));
        WinningRepository winningRepository = new WinningRepository();
        WinningNumber winningNumber = new WinningNumber(List.of("1", "2", "3", "4", "5", "6"));
        BonusNumber bonusNumber = new BonusNumber("7", winningNumber);

        LotteryCheckService lotteryCheckService = new LotteryCheckService();

        lotteryCheckService.lotteryCheck(lottoRepository, winningRepository, winningNumber, bonusNumber);

        for (WinningCondition winningCondition : WinningCondition.values()) {
            assertEquals(1L, winningRepository.getAllCounts().get(winningCondition));
        }
    }

}
