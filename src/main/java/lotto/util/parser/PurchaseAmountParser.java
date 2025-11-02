package lotto.util.parser;

import lotto.config.ErrorMessage;

public class PurchaseAmountParser {
    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }
}
