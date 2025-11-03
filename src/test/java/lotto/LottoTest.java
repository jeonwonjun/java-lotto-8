package lotto;

import java.util.stream.Stream;
import lotto.domain.entity.BonusNumber;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.WinningNumbers;
import lotto.util.RandomNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void setup() {
        List<Integer> winningList = List.of(1, 2, 3, 4, 5, 6);
        BonusNumber bonus = new BonusNumber(7, winningList);
        winningNumbers = new WinningNumbers(winningList, bonus);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
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
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(0, 1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호의 일치 갯수를 정확히 반환해야 한다.")
    @ParameterizedTest
    @MethodSource("matchList")
    void 정확한_일치_갯수(List<Integer> lottoNumbers, int expectedCount, boolean expectedMatch) {
        // given
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        int actualCount = lotto.countMatch(winningNumbers);

        // then
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있는지 정확히 반환해야 한다.")
    @ParameterizedTest
    @MethodSource("matchList")
    void 정확한_보너스_일치(List<Integer> lottoNumbers, int expectedCount, boolean expectedMatch) {
        // given
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        boolean actualMatch = lotto.containsBonusNumber(winningNumbers);

        // then
        assertThat(actualMatch).isEqualTo(expectedMatch);
    }
    private static Stream<Object> matchList() {
        return Stream.of(
                Arguments.of(List.of(8, 9, 10, 11, 12, 13), 0, false),
                Arguments.of(List.of(1, 8, 9, 10, 11, 12), 1, false),
                Arguments.of(List.of(1, 2, 9, 10, 11, 12), 2, false),
                Arguments.of(List.of(1, 2, 7, 10, 11, 12), 2, true),
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), 3, false),
                Arguments.of(List.of(1, 2, 3, 7, 11, 12), 3, true),
                Arguments.of(List.of(1, 2, 3, 4, 11, 12), 4, false),
                Arguments.of(List.of(1, 2, 3, 4, 5, 12), 5, false),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5, true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, false)
        );
    }
}
