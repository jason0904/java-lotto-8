package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.config.LottoRule;
import lotto.model.Lotto;
import lotto.model.LottoRepository;
import lotto.model.PurchaseAmount;

public class LottoMakeService {

    public Lotto makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoRule.MIN_NUMBER.getValue(),
                LottoRule.MAX_NUMBER.getValue(),
                LottoRule.SIZE.getValue());

        return new Lotto(lottoNumbers);
    }

    public LottoRepository makeLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = IntStream.range(0, purchaseAmount.getLottoCount())
                .mapToObj(i -> makeLotto())
                .toList();
        return new LottoRepository(lottos);
    }
}
