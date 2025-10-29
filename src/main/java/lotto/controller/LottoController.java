package lotto.controller;

import java.util.function.Supplier;

import lotto.view.LottoInputView;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumber;
import lotto.model.BonusNumber;

public class LottoController {

    private final LottoInputView lottoInputView;

    public LottoController(LottoInputView lottoInputView) {
        this.lottoInputView = lottoInputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = errorCatch(() -> lottoInputView.purchaseInput());
        WinningNumber winningNumber = errorCatch(() -> lottoInputView.winningNumberInput());
        BonusNumber bonusNumber = errorCatch(() -> lottoInputView.bonusNumberInput(winningNumber));

    }

    private <T> T errorCatch(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
