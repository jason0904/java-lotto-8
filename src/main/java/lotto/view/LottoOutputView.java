package lotto.view;

import lotto.model.LottoRepository;
import lotto.model.PurchaseAmount;

import java.util.stream.Collectors;

import lotto.model.Lotto;

public class LottoOutputView {

    public void printLottos(LottoRepository lottoRepository, PurchaseAmount purchaseAmount) {
        System.out.printf("%d개를 구매하였습니다.\n", purchaseAmount.getPurchaseAmount());
        for(Lotto lotto : lottoRepository.getLottos()) {
            String numbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
            System.out.printf("[%s]\n", numbers);
        }

    }
    
}
