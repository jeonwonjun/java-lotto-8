package lotto.domain.record;

import lotto.config.ErrorMessage;

public record PurchaseAmount(int amount) {
    private static final int LOTTO_PRICE = 1000;

    public PurchaseAmount {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_MIN.getMessage());
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_POINT.getMessage());
        }
    }

    public int getTicketCount() {
        return this.amount() / LOTTO_PRICE;
    }
}
