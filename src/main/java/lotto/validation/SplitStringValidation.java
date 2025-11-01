package lotto.validation;

public final class SplitStringValidation {

    private SplitStringValidation() {
    }

    public static void validateComma(final String input) {
        validateStringStartWithComma(input);
        validateStringEndWithComma(input);
    }

    private static void validateStringStartWithComma(final String input) {
        if (input.startsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.STRING_STARTS_WITH_COMMA.getMessage());
        }
    }

    private static void validateStringEndWithComma(final String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.STRING_ENDS_WITH_COMMA.getMessage());
        }
    }
}
