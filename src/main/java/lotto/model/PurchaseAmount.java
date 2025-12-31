package lotto.model;

import lotto.config.ErrorMessage;

public class PurchaseAmount {
    private static final int TICKET_AMOUNT = 1000;
    private final int purchaseAmount;

    public PurchaseAmount(String purchaseAmountInput) {
        this.purchaseAmount = parseToPurchaseAmount(purchaseAmountInput);
    }

    private int parseToPurchaseAmount(String purchaseAmountInput) {
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        validate(purchaseAmount);
        return purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        validatePurchaseAmountMin(purchaseAmount);
        validatePurchaseAmountFormat(purchaseAmount);
    }

    private void validatePurchaseAmountMin(int purchaseAmount) {
        if (purchaseAmount < TICKET_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MIN_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void validatePurchaseAmountFormat(int purchaseAmount) {
        if (purchaseAmount % TICKET_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_FORMAT.getMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTicketAmount() {
        return purchaseAmount / TICKET_AMOUNT;
    }
}
