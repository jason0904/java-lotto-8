package lotto.model;

import lotto.config.LottoRule;
import lotto.validation.ErrorMessage;

public class PurchaseAmount {
    private final Long purchaseAmount;

    public PurchaseAmount(String purchaseAmountText) {
        validate(purchaseAmountText);
        purchaseAmount = Long.parseLong(purchaseAmountText) / LottoRule.PURCHASE_UNIT.getValue();
    }

    private void validate(String purchaseAmountText) {
        validateAmountIsLong(purchaseAmount);
        validatePositiveAmount(purchaseAmount);
        validateZeroAmount(purchaseAmount);
        validateUnitAmount(purchaseAmount);
    }

    private void validatePositiveAmount(Long purchaseAmount) {
        if(purchaseAmount < 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_POSITIVE.getMessage());
        }
    }

    private void validateZeroAmount(Long purchaseAmount) {
        if(purchaseAmount == 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO.getMessage());
        }
    }

    private void validateAmountIsLong(Long purchaseAmount) {
        try {
            Long.parseLong(String.valueOf(purchaseAmount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_LONG.getMessage());
        }
    }

    private void validateUnitAmount(Long purchaseAmount) {
        if(purchaseAmount % LottoRule.PURCHASE_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    public Long getPurchaseAmount() {
        return purchaseAmount;
    }

}
