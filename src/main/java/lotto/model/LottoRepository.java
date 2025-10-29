package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LottoRepository {
    
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoRepository(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
