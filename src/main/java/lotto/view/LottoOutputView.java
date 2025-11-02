package lotto.view;

import lotto.model.LottoRepository;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.WinningCondition;
import lotto.model.WinningRepository;

import java.util.stream.Collectors;

public class LottoOutputView {

    private static final String PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBER_FORMAT = "[%s]\n";
    private static final String RESULT_HEADER_MESSAGE = "\n당첨 통계\n---";
    private static final String RESULT_LINE_FORMAT = "%d개 일치%s (%,d원) - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final String BONUS_MATCH_STRING = ", 보너스 볼 일치";
    private static final String EMPTY_STRING = "";

    public void printLottos(final LottoRepository lottoRepository, final PurchaseAmount purchaseAmount) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, purchaseAmount.getLottoCount());
        lottoRepository.getLottos().forEach(lotto -> System.out.printf(LOTTO_NUMBER_FORMAT, formatLottoNumbers(lotto)));
    }

    public void printLotteryResult(final WinningRepository winningRepository) {
        System.out.println(RESULT_HEADER_MESSAGE);
        for (final WinningCondition winningCondition : WinningCondition.values()) {
            System.out.printf(RESULT_LINE_FORMAT,
                    winningCondition.getMatchCount(),
                    getBonusString(winningCondition),
                    winningCondition.getPrize(),
                    winningRepository.getCount(winningCondition));
        }
    }

    public void printProfitRate(final double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }

    public void printError(final String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }

    private String formatLottoNumbers(final Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private String getBonusString(final WinningCondition winningCondition) {
        if (winningCondition == WinningCondition.SECOND) {
            return BONUS_MATCH_STRING;
        }
        return EMPTY_STRING;
    }
}
