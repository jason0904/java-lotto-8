package lotto.validation;

public enum LottoRule {
    LOTTO_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    PURCHASE_UNIT(1000);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}
