package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

import lotto.validation.LottoRule;

public class LottoMakeService {

    public Lotto makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoRule.MIN_NUMBER.getValue(), 
        LottoRule.MAX_NUMBER.getValue(), 
        LottoRule.LOTTO_SIZE.getValue());

        return new Lotto(lottoNumbers);
    }

    public LottoRepository makeLottos(int count) {
        List<Lotto> lottos = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            lottos.add(makeLotto());
        }
        return new LottoRepository(lottos);
    }
}
