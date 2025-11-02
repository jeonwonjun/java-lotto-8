package lotto.util.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("공백이 들어오면 예외처리 합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"8 000", " 8000", "8000 "})
    void 예외_입력_공백(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));
    }
}
