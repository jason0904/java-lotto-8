package lotto.model;

import lotto.validation.ErrorMessage;
import lotto.validation.LottoRule;

public class BonusNumber {

    private final int value;

    public BonusNumber(int value, WinningNumber winningNumber) {
        validate(value, winningNumber);
        this.value = value;
    }

    private void validate(int value, WinningNumber winningNumber) {
        validateNumberRange(value);
        validateDuplicateWithWinningNumbers(value, winningNumber);
    }

    private void validateNumberRange(int value) {
        if (value < LottoRule.MIN_NUMBER.getValue() || value > LottoRule.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicateWithWinningNumbers(int value, WinningNumber winningNumber) {
        if (winningNumber.getWinningNumbers().contains(value)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public int getValue() {
        return value;
    }

}