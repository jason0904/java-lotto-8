package lotto.model;

import java.util.List;
import lotto.validation.ErrorMessage;

public class WinningNumber {

    private final Lotto winningNumbers;

    public WinningNumber(List<String> input) {
        List<Integer> numbers = validateNumbersAndParse(input);
        this.winningNumbers = new Lotto(numbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    private List<Integer> validateNumbersAndParse(List<String> input) {
        try {
            return input.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
