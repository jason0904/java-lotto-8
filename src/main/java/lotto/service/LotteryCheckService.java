package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.model.WinningCondition;
import lotto.model.WinningNumber;
import lotto.model.WinningRepository;

public class LotteryCheckService {

    public void lotteryCheck(LottoRepository lottoRepository, WinningRepository winningRepository,
            WinningNumber winningNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottoRepository.getLottos()) {
            WinningCondition winningCondition = WinningCondition.fromMatchCounts(lotto, winningNumber, bonusNumber);
            winningRepository.addCount(winningCondition);
        }
    }
}
