package lotto.util.parser;

import lotto.config.ErrorMessage;

public class BonusNumberParser {
    public static int parse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
