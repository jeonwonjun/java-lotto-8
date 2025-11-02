package lotto.util.parser;

import java.util.List;
import java.util.stream.Collectors;
import lotto.config.ErrorMessage;

public class WinningNumbersParser {
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUT_BLANK = " ";

    public static List<Integer> parse(String input) {
        List<String> splitInput = parseByDelimiter(input);
        validate(splitInput);
        return convertTo(splitInput);
    }

    private static void validate(List<String> splitInput) {
        for (String splitNumber : splitInput) {
            validateBlank(splitNumber);
        }
    }

    private static void validateBlank(String splitNumber) {
        if (splitNumber.isEmpty() || splitNumber.contains(INPUT_BLANK)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NUMBER.getMessage());
        }
    }

    private static List<String> parseByDelimiter(String input) {
        return List.of(input.split(INPUT_DELIMITER));
    }

    private static List<Integer> convertTo(List<String> splitInput) {
        try {
            return splitInput.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }


}
