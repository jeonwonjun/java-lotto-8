package lotto.domain.entity;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    private final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호는 1~45 사이의 값이 입력되어야 합니다.")
    @ParameterizedTest
    @ValueSource(ints = {-6, 0, 46})
    void 예외_보너스_번호_범위(int input) {
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input, numbers));
    }

    @DisplayName("보너스 번호는 입력받은 당첨번호와 중복되면 안됩니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 예외_보너스_번호_중복(int input) {
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input, numbers));
    }

    @DisplayName("정상적인 보너스 번호 입력입니다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 10, 45})
    void 정상_보너스_번호(int input) {
        assertDoesNotThrow(() -> new BonusNumber(input, numbers));
    }

}
