package lotto.model;

import lotto.validation.ErrorMessage;

public class PurchaseAmount {
    private final Long purchaseAmount;

    public PurchaseAmount(String purchaseAmountText) {
        validate(purchaseAmountText);
        purchaseAmount = Long.parseLong(purchaseAmountText);
    }

    private void validate(String purchaseAmountText) {
        Long validatePurchaseAmount = 0L;
        
        try {
            validatePurchaseAmount = Long.parseLong(purchaseAmountText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MAX.getMessage());
        }

        if(validatePurchaseAmount < 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_POSITIVE.getMessage());
        }

        if(validatePurchaseAmount == 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO.getMessage());
        }

        if(validatePurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT.getMessage());
        }

    }

    public Long getPurchaseAmount() {
        return purchaseAmount;
    }

}
