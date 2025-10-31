package lotto.service;

import lotto.config.WinningCondition;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.model.WinningNumber;
import lotto.model.WinningRepository;

public class LotteryCheckService {

    public void lotteryCheck(LottoRepository lottoRepository,
            WinningRepository winningRepository,
            WinningNumber winningNumber,
            BonusNumber bonusNumber) {
        for (Lotto lotto : lottoRepository.getLottos()) {
            checkConditions(lotto, winningRepository, winningNumber, bonusNumber);
        }
    }

    private void checkConditions(Lotto lotto,
            WinningRepository winningRepository,
            WinningNumber winningNumber,
            BonusNumber bonusNumber) {
        for (WinningCondition winningCondition : WinningCondition.values()) {
            if (checkMatchCondition(lotto, winningCondition, winningNumber, bonusNumber)) {
                winningRepository.addCount(winningCondition);
                return;
            }
        }
    }

    private boolean checkMatchCondition(Lotto lotto,
            WinningCondition winningCondition,
            WinningNumber winningNumber,
            BonusNumber bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(number -> winningNumber.getWinningNumbers().contains(number))
                .count();

        if (winningCondition == WinningCondition.SECOND) {
            return matchCount == winningCondition.getMatchCount()
                    && lotto.getNumbers().contains(bonusNumber.getValue());
        }
        return matchCount == winningCondition.getMatchCount();
    }
}
