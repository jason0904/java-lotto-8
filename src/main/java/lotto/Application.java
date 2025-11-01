package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.service.LotteryCheckService;
import lotto.service.LottoMakeService;
import lotto.service.LottoProfitService;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {

        InputController inputController = new InputController();
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoMakeService lottoMakeService = new LottoMakeService();
        LotteryCheckService lotteryCheckService = new LotteryCheckService();
        LottoProfitService lottoProfitService = new LottoProfitService();
        LottoController lottoController = new LottoController(inputController, lottoOutputView, lottoMakeService,
                lotteryCheckService, lottoProfitService);

        lottoController.run();
    }
}
