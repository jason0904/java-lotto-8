package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.ErrorMessage;
import lotto.validation.LottoRule;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<String> input) {
        validate(input);
        this.winningNumbers = input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    
    private void validate(List<String> input) {
        validateLottoSize(input.size());

        for(String number : input) {
            validateNumberIsInteger(number);
            validateNumberRange(Integer.parseInt(number));
        }
    }

    public static void validateLottoSize(int size) {
        if (size != LottoRule.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_COUNT.getMessage());
        }
    }

    public static void validateNumberIsInteger(String numberText) {
        try {
            Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateNumberRange(int number) {
        if (number < LottoRule.MIN_NUMBER.getValue() || number > LottoRule.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

}
