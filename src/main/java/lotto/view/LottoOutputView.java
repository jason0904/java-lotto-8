package lotto.view;

import lotto.model.LottoRepository;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.WinningRepository;
import lotto.config.WinningCondition;

import java.util.stream.Collectors;

public class LottoOutputView {

    public void printLottos(LottoRepository lottoRepository, PurchaseAmount purchaseAmount) {
        System.out.printf("%d개를 구매하였습니다.\n", purchaseAmount.getPurchaseAmount());
        for (Lotto lotto : lottoRepository.getLottos()) {
            String numbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.printf("[%s]\n", numbers);
        }

    }

    public void printLotteryResult(WinningRepository winningRepository) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningCondition winningCondition : WinningCondition.values()) {
            System.out.printf("%d개 일치%s (%,d원) - %d개\n",
                    winningCondition.getMatchCount(),
                    getBonusString(winningCondition),
                    winningCondition.getPrize(),
                    winningRepository.getAllCounts().get(winningCondition));
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", profitRate);
    }

    private String getBonusString(WinningCondition winningCondition) {
        if (winningCondition == WinningCondition.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    

}
