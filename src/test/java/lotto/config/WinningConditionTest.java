package lotto.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningConditionTest {

    @Test
    @DisplayName("당첨 조건 확인 테스트")
    void testLotteryCheckService() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 7, 8)), // 4등
                new Lotto(List.of(1, 2, 3, 7, 8, 9)), // 5등
                new Lotto(List.of(10, 11, 12, 13, 14, 15)) // 낙첨
        );

        WinningNumber winningNumber = new WinningNumber(List.of("1", "2", "3", "4", "5", "6"));
        BonusNumber bonusNumber = new BonusNumber("7", winningNumber);

        for (int i = 0; i < lottos.size(); i++) {
            WinningCondition winningCondition = WinningCondition.fromMatchCounts(lottos.get(i), winningNumber,
                    bonusNumber);
            assertEquals(WinningCondition.values()[i], winningCondition);
        }
    }
}
