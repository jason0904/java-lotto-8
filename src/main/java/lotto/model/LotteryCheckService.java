package lotto.model;

import lotto.config.WinningCondition;

public class LotteryCheckService {
    
    private final LottoRepository lottoRepository;
    private final WinningRepository winningRepository;
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public LotteryCheckService(LottoRepository lottoRepository, WinningRepository winningRepository, 
    WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.lottoRepository = lottoRepository;
        this.winningRepository = winningRepository;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public void lotteryCheck() {
        for(Lotto lotto : lottoRepository.getLottos()) {
            checkConditions(lotto);
        }
    }

    public void checkConditions(Lotto lotto) {
        for(WinningCondition winningCondition : WinningCondition.values()) {
            if(checkMatchCondition(lotto, winningCondition)) {
                winningRepository.addCount(winningCondition);
                return;
            }
        }
    }

    public boolean checkMatchCondition(Lotto lotto, WinningCondition winningCondition) {
        int matchCount = (int) lotto.getNumbers().stream()
            .filter(number -> winningNumber.getWinningNumbers().contains(number))
            .count();

        if (winningCondition == WinningCondition.SECOND) {
            return matchCount == winningCondition.getMatchCount() &&
                lotto.getNumbers().contains(bonusNumber.getValue());
        }

        return matchCount == winningCondition.getMatchCount();
    }
}
