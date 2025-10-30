package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;
import lotto.model.LottoMakeService;
import lotto.model.LotteryCheckService;
import lotto.model.LottoProfitService;

public class Application {
    public static void main(String[] args) {

        LottoInputView lottoInputView = new LottoInputView();
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoMakeService lottoMakeService = new LottoMakeService();
        LotteryCheckService lotteryCheckService = new LotteryCheckService();
        LottoProfitService lottoProfitService = new LottoProfitService();
        LottoController lottoController = new LottoController(lottoInputView, lottoOutputView, lottoMakeService,
                lotteryCheckService, lottoProfitService);

        lottoController.run();
    }
}
