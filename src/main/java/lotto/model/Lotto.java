package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.config.LottoRule;
import lotto.validation.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = Collections.unmodifiableList(sortedNumbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        numbers.forEach(this::validateNumberRange);
        validateDuplicateNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateNumberRange(int value) {
        if (value < LottoRule.MIN_NUMBER.getValue() || value > LottoRule.MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }
}
