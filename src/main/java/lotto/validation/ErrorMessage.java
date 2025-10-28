package lotto.validation;

public enum ErrorMessage {
    ERROR_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위로 입력해야 합니다."),
    ERROR_PURCHASE_AMOUNT_POSITIVE("구입 금액은 양수여야 합니다."),
    ERROR_PURCHASE_AMOUNT_ZERO("구입 금액은 0원일 수 없습니다."),
    ERROR_PURCHASE_AMOUNT_MAX("최대 구입 금액을 초과했습니다."),
    ERROR_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 정수여야 합니다."),
    ERROR_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    ERROR_DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    ERROR_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다.");

    private final String ERROR_MARK = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_MARK + " " + message;
    }

    public String getMessage() {
        return message;
    }

}
