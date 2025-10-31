package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.config.LottoRule;
import lotto.validation.ErrorMessage;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<String> input) {
        List<Integer> numbers = validateNumbersAndParse(input);
        validate(numbers);
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    private List<Integer> validateNumbersAndParse(List<String> input) {
        try {
            return input.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoRule.MIN_NUMBER.getValue() || number > LottoRule.MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
    
}
