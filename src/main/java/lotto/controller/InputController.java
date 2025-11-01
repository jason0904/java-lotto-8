package lotto.controller;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumber;
import lotto.validation.SplitStringValidation;
import lotto.view.LottoInputView;

public class InputController {

    private final LottoInputView lottoInputView = new LottoInputView();
    
    public PurchaseAmount purchaseInput() {
        lottoInputView.showPurchaseInputMessage();
        return new PurchaseAmount(Console.readLine());
    }

    public WinningNumber winningNumberInput() {
        lottoInputView.showWinningNumberInputMessage(); 
        String input = Console.readLine();
        SplitStringValidation.validateComma(input);
        List<String> numbers = Arrays.asList(input.split(","));
        return new WinningNumber(numbers);
    }

    public BonusNumber bonusNumberInput(WinningNumber winningNumber) {
        lottoInputView.showBonusNumberInputMessage();
        String input = Console.readLine();
        return new BonusNumber(input, winningNumber);
    }

}
