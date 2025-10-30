package lotto.model;

import lotto.config.LottoRule;
import lotto.validation.ErrorMessage;

public class BonusNumber {

    private final int value;

    public BonusNumber(String value, WinningNumber winningNumber) {
        validate(value, winningNumber);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value, WinningNumber winningNumber) {
        validateNumberIsInteger(value);
        validateNumberRange(Integer.parseInt(value));
        validateDuplicateWithWinningNumbers(Integer.parseInt(value), winningNumber);
    }

    private void validateNumberIsInteger(String numberText) {
        try {
            Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }
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