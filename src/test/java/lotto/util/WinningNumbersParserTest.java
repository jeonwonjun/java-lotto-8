package lotto.util;

import static lotto.util.parser.WinningNumbersParser.parse;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersParserTest {

    @DisplayName("로또 번호는 숫자로만 이루어져야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,1,2,3,4,5", "1,2,3,4,,6", "1,2, 1 3,4,5,6"} )
    void 로또_번호_형식_테스트(String lottoNumber) {
        assertThatThrownBy(() -> parse(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
