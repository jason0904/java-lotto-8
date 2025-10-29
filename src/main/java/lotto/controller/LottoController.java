package lotto.controller;

import java.util.function.Supplier;

import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumber;
import lotto.model.BonusNumber;
import lotto.model.LottoMakeService;
import lotto.model.LottoRepository;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoMakeService lottoMakeService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView, LottoMakeService lottoMakeService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoMakeService = lottoMakeService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = errorCatch(() -> lottoInputView.purchaseInput());
        LottoRepository lottoRepository = makeLottos(purchaseAmount);

        WinningNumber winningNumber = errorCatch(() -> lottoInputView.winningNumberInput());


        BonusNumber bonusNumber = errorCatch(() -> lottoInputView.bonusNumberInput(winningNumber));
        
    }

    private LottoRepository makeLottos(PurchaseAmount purchaseAmount) {
        LottoRepository lottoRepository = lottoMakeService.makeLottos(purchaseAmount.getPurchaseAmount());
        lottoOutputView.printLottos(lottoRepository, purchaseAmount);

        return lottoRepository;
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
