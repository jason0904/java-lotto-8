package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.config.LottoRule;
import lotto.validation.ErrorMessage;

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

        validateDuplicateNumber(input);
    }

    private void validateLottoSize(int size) {
        if (size != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private void validateNumberIsInteger(String numberText) {
        try {
            Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if (number < LottoRule.MIN_NUMBER.getValue() || number > LottoRule.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicateNumber(List<String> input) {
        long distinctCount = input.stream()
                .distinct()
                .count();

        if (distinctCount != input.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }


}
