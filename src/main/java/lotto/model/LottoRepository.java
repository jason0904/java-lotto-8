package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LottoRepository {
    
    private final List<Lotto> lottos;

    public LottoRepository(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(new ArrayList<>(lottos));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
