package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

import lotto.config.WinningCondition;

public class WinningRepository {

    private final EnumMap<WinningCondition, Long> winningCounts = new EnumMap<>(WinningCondition.class);

    public WinningRepository() {
        for(WinningCondition winningCondition : WinningCondition.values()) {
            winningCounts.put(winningCondition, 0L);
        }
    }

    public void addCount(WinningCondition winningCondition) {
        Objects.requireNonNull(winningCondition);
        winningCounts.put(winningCondition, winningCounts.getOrDefault(winningCondition, 0L) + 1L);
    }

    public Long getTotalPrize() {
        long totalPrize = 0L;
        for (Map.Entry<WinningCondition, Long> entry : winningCounts.entrySet()) {
            WinningCondition condition = entry.getKey();
            Long count = entry.getValue();
            totalPrize += condition.getPrize() * count;
        }
        return totalPrize;
    }

    public Map<WinningCondition, Long> getAllCounts() {
        return Collections.unmodifiableMap(winningCounts);
    }

    
}
