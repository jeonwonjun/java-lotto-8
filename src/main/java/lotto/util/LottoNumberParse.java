package lotto.util;

import java.util.List;

public class LottoNumberParse {
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUT_BLANK = " ";

    public static List<String> parse(String input) {
        List<String> splitInput = List.of(input.split(INPUT_DELIMITER));
        for (String splitnumber : splitInput) {
            validate(splitnumber);
        }
        return splitInput;
    }

    private static void validate(String splitNumber) {
        splitNumber = splitNumber.trim();
        if (splitNumber.isEmpty() || splitNumber.contains(INPUT_BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NUMBER.getMessage());
        }
    }
}
