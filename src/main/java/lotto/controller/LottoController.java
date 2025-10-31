package lotto.controller;

import java.util.function.Supplier;

import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumber;
import lotto.model.WinningRepository;
import lotto.service.LotteryCheckService;
import lotto.service.LottoMakeService;
import lotto.service.LottoProfitService;
import lotto.model.BonusNumber;
import lotto.model.LottoRepository;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoMakeService lottoMakeService;
    private final LotteryCheckService lotteryCheckService;
    private final LottoProfitService lottoProfitService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView,
            LottoMakeService lottoMakeService, LotteryCheckService lotteryCheckService, LottoProfitService lottoProfitService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoMakeService = lottoMakeService;
        this.lotteryCheckService = lotteryCheckService;
        this.lottoProfitService = lottoProfitService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = purchaseInput();
        LottoRepository lottoRepository = makeLottos(purchaseAmount);
        WinningNumber winningNumber = winningNumberInput();
        BonusNumber bonusNumber = bonusNumberInput(winningNumber);
        WinningRepository winningRepository = lotteryCheck(lottoRepository, winningNumber, bonusNumber);
        printProfitRate(purchaseAmount, winningRepository);
    }

    private PurchaseAmount purchaseInput() {
        PurchaseAmount purchaseAmount = errorCatch(() -> lottoInputView.purchaseInput());
        lottoOutputView.printNewLine();
        
        return purchaseAmount;
    }

    private WinningNumber winningNumberInput() {
        WinningNumber winningNumber = errorCatch(() -> lottoInputView.winningNumberInput());
        lottoOutputView.printNewLine();

        return winningNumber;
    }

    private BonusNumber bonusNumberInput(WinningNumber winningNumber) {
        BonusNumber bonusNumber = errorCatch(() -> lottoInputView.bonusNumberInput(winningNumber));
        lottoOutputView.printNewLine();

        return bonusNumber;
    }

    private LottoRepository makeLottos(PurchaseAmount purchaseAmount) {
        LottoRepository lottoRepository = lottoMakeService.makeLottos(purchaseAmount);
        lottoOutputView.printLottos(lottoRepository, purchaseAmount);
        lottoOutputView.printNewLine();

        return lottoRepository;
    }

    private WinningRepository lotteryCheck(LottoRepository lottoRepository, WinningNumber winningNumber, BonusNumber bonusNumber) {
        WinningRepository winningRepository = new WinningRepository();
        lotteryCheckService.lotteryCheck(lottoRepository, winningRepository, winningNumber, bonusNumber);
        lottoOutputView.printLotteryResult(winningRepository);

        return winningRepository;
    }

    private void printProfitRate(PurchaseAmount purchaseAmount, WinningRepository winningRepository) {
        double profitRate = lottoProfitService.calculateProfitRate(purchaseAmount, winningRepository);
        lottoOutputView.printProfitRate(profitRate);
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
