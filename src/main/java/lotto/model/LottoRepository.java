package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoRepository(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
