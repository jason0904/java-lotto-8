package lotto.validation;

import java.util.function.Supplier;

public enum ErrorMessage {
    PURCHASE_AMOUNT_UNIT(() -> "구입 금액은 1,000원 단위로 입력해야 합니다."),
    PURCHASE_AMOUNT_POSITIVE(() -> "구입 금액은 양수여야 합니다."),
    PURCHASE_AMOUNT_ZERO(() -> "구입 금액은 0원일 수 없습니다."),
    PURCHASE_AMOUNT_MAX(() -> "최대 구입 금액을 초과했습니다."),
    WINNING_NUMBER_RANGE(() -> String.format("당첨 번호는 %d부터 %d 사이의 정수여야 합니다.", LottoRule.MIN_NUMBER.getValue(), LottoRule.MAX_NUMBER.getValue())),
    WINNING_NUMBER_SIZE(() -> "당첨 번호는 6개여야 합니다."),
    LOTTO_SIZE(() -> "로또 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBER(() -> "당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_FORMAT(() -> "당첨 번호는 쉼표(,)로 구분된 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER(() -> "보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    STRING_STARTS_WITH_COMMA(() -> "입력 값은 쉼표(,)로 시작할 수 없습니다."),
    STRING_ENDS_WITH_COMMA(() -> "입력 값은 쉼표(,)로 끝날 수 없습니다.");

    private static final String ERROR_MARK = "[ERROR]";
    private final Supplier<String> messageSupplier;

    ErrorMessage(Supplier<String> messageSupplier) {
        this.messageSupplier = messageSupplier;
    }

    public String getMessage() {
        return ERROR_MARK + " " + messageSupplier.get();
    }
}
