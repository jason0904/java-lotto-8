package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoRule;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.model.PurchaseAmount;

import java.util.List;
import java.util.ArrayList;

public class LottoMakeService {

    public Lotto makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoRule.MIN_NUMBER.getValue(),
                LottoRule.MAX_NUMBER.getValue(),
                LottoRule.SIZE.getValue());

        return new Lotto(lottoNumbers);
    }

    public LottoRepository makeLottos(PurchaseAmount purchaseAmount) {
        int count = (int) (purchaseAmount.getPurchaseAmount() / LottoRule.PURCHASE_UNIT.getValue());
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(makeLotto());
        }
        return new LottoRepository(lottos);
    }
}
