package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.validation.ErrorMessage;
import lotto.validation.LottoRule;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE.getMessage());
        }
    }

    private void sortNumbers() {
        numbers.sort(Integer::compareTo);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
