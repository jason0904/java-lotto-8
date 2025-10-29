package lotto.validation;

public class SplitStringValidation {

    public static void validateStringStartWithComma(String input) {
        if (input.startsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.STRING_STARTS_WITH_COMMA.getMessage());
        }
    }

    public static void validateStringEndWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.STRING_ENDS_WITH_COMMA.getMessage());
        }
    }
}
