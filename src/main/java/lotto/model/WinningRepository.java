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

    public void setCount(WinningCondition winningCondition, Long count) {
        Objects.requireNonNull(winningCondition);
        winningCounts.put(winningCondition, count);
    }

    public Map<WinningCondition, Long> getAllCounts() {
        return Collections.unmodifiableMap(winningCounts);
    }

    
}
