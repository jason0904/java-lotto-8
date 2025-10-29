package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.validation.WinningNumberValidation;
import lotto.validation.LottoValidation;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<String> input) {
        validate(input);
        this.winningNumbers = input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    
    private void validate(List<String> input) {
        LottoValidation.validateLottoSize(input.size());

        for(String number : input) {
            WinningNumberValidation.validateNumberIsInteger(number);
            WinningNumberValidation.validateNumberRange(Integer.parseInt(number));
        }
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

}
