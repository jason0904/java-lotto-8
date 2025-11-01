package lotto.view;

public class LottoInputView {

    private final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void showPurchaseInputMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        
    }

    public void showWinningNumberInputMessage() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void showBonusNumberInputMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

}
