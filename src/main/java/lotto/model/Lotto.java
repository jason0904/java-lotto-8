package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.validation.LottoNumberValidation;
import lotto.validation.LottoValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        LottoValidation.validateLottoSize(numbers.size());

        for(Integer number : numbers) {
            LottoNumberValidation.validateNumberRange(number);
        }
    }

    private void sortNumbers() {
        numbers.sort(Integer::compareTo);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
