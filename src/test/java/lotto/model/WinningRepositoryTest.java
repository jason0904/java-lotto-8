package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.config.WinningCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}