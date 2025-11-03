package lotto.util;

import static lotto.util.WinningNumbersParser.parse;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersParserTest {

    @DisplayName("로또 번호는 공백은 입력되면 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,4,5", "1,2,3,4,,6,7", "1,2, 1 3,4,5,6", "1,2,3,4,5,6 "})
    void 예외_당첨_번호_공백(String input) {
        assertThatThrownBy(() -> parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 숫자로만 입력되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,2,3,4,5,6", "1,2,3,/,5,6", ";;"})
    void 예외_당첨_번호_형식(String input) {
        assertThatThrownBy(() -> parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
