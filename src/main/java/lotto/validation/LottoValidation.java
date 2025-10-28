package lotto.validation;

public class LottoValidation {

    public static final int LOTTO_SIZE = 6;

    public static void validateLottoSize(int size) {
        if (size != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_COUNT.getMessage());
        }
    }
    
}
