package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.BonusNumber;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumber;
import lotto.validation.SplitStringValidation;

import java.util.List;

public class LottoInputView {

    private final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public PurchaseAmount purchaseInput() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return new PurchaseAmount(Console.readLine());
    }

    public WinningNumber winningNumberInput() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        SplitStringValidation.validateComma(input);
        List<String> numbers = java.util.Arrays.asList(input.split(","));
        return new WinningNumber(numbers);
    }

    public BonusNumber bonusNumberInput(WinningNumber winningNumber) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        return new BonusNumber(input, winningNumber);
    }




}
