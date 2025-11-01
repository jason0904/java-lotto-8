package lotto.service;

import lotto.model.PurchaseAmount;
import lotto.model.WinningRepository;

public class LottoProfitService {

    public double calculateProfitRate(PurchaseAmount purchaseAmount, WinningRepository winningRepository) {
        Long totalPrize = winningRepository.getTotalPrize();
        Long totalCost = purchaseAmount.getPurchaseAmount();
        if (totalCost == 0) {
            return 0.0;
        }
        return (double) totalPrize / totalCost * 100;
    }
    
}
