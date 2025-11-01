package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumber;
import lotto.validation.ErrorMessage;
import lotto.validation.SplitStringValidation;
import lotto.view.LottoInputView;

public class InputController {

    private final LottoInputView lottoInputView = new LottoInputView();
    
    public PurchaseAmount purchaseInput() {
        lottoInputView.showPurchaseInputMessage();
        String input = Console.readLine();
        validateIsBlank(input);
        return new PurchaseAmount(input);
    }

    public WinningNumber winningNumberInput() {
        lottoInputView.showWinningNumberInputMessage(); 
        String input = Console.readLine();
        validateIsBlank(input);
        SplitStringValidation.validateComma(input);
        List<String> numbers = Arrays.asList(input.split(","));
        return new WinningNumber(numbers);
    }

    public BonusNumber bonusNumberInput(WinningNumber winningNumber) {
        lottoInputView.showBonusNumberInputMessage();
        String input = Console.readLine();
        validateIsBlank(input);
        return new BonusNumber(input, winningNumber);
    }

    private void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.STRING_EMPTY.getMessage());
        }
    }
}
