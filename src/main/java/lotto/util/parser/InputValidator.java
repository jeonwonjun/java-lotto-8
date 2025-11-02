package lotto.util.parser;

import static lotto.view.OutputView.printMessage;

import lotto.config.ErrorMessage;

public class InputValidator {
    private static final String BLANK = " ";

    public static int validate(String input) {
        try {
            validateBlank(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_NUMBER.getMessage());
        }
    }
}
