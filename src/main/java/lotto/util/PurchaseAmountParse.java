package lotto.util;

import lotto.config.ErrorMessage;

public class PurchaseAmountParse {
    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUN_FORMAT.getMessage());
        }
    }
}
