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

        for (Long count : winningRepository.getAllCounts().values()) {
            assertEquals(count, 0L);
        }
    }

    @Test
    @DisplayName("WinningRepository 당첨기록 추가 테스트")
    void testAddCount() {
        WinningRepository winningRepository = new WinningRepository();
        assertEquals(winningRepository.getAllCounts().get(WinningCondition.FIRST), 0L);

        winningRepository.addCount(WinningCondition.FIRST);
        assertEquals(winningRepository.getAllCounts().get(WinningCondition.FIRST), 1L);
    }
    
}