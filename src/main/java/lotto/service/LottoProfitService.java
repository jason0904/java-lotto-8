package lotto.service;

import lotto.model.PurchaseAmount;
import lotto.model.WinningRepository;

public class LottoProfitService {

    public double calculateProfitRate(PurchaseAmount purchaseAmount, WinningRepository winningRepository) {
        return winningRepository.calculateTotalProfitRate(purchaseAmount);
    }
    
}
