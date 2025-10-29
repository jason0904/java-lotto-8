package lotto.validation;

public class WinningNumberValidation {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static void validateNumberIsInteger(String numberText) {
        try {
            Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE.getMessage());
        }
    }

    
}
