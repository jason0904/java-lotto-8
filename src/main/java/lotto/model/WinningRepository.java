package lotto.model;

import java.util.EnumMap;
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

    public Long getCount(WinningCondition winningCondition) {
        Objects.requireNonNull(winningCondition);
        return winningCounts.getOrDefault(winningCondition, 0L);
    }

    public double calculateTotalProfitRate(PurchaseAmount purchaseAmount) {
        Long totalPrize = getTotalPrize();
        Long totalCost = purchaseAmount.getPurchaseAmount();
        if (totalCost == 0) {
            return 0.0;
        }
        return (double) totalPrize / totalCost * 100;
    }

    private Long getTotalPrize() {
        return winningCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    
}
