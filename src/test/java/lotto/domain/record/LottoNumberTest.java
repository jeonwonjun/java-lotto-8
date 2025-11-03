package lotto.domain.record;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("로또 번호는 1에서 45 사이어야 합니다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 101})
    void 예외_로또_범위(int input) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(input));
    }
}
