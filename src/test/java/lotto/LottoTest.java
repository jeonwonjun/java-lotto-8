package lotto;

import java.util.stream.Stream;
import lotto.domain.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 1~45 사이의 값이어야 합니다.")
    @ParameterizedTest
    @MethodSource("provideLottoRange")
    void 로또_번호_범위_테스트(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideLottoRange() {
        return Stream.of(
                Arguments.of(1, 2, 3, 4, 5, 46),
                Arguments.of(0, 1, 2, 3, 4, 5)
        );
    }
}
