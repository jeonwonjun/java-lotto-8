package lotto.config;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoRankTest {
    private static Stream<Arguments> rankData() {
        return Stream.of(
                Arguments.of(6, false, LottoRank.FIRST), // 6개 일치 (1등)
                Arguments.of(5, true, LottoRank.SECOND),  // 5개 일치 + 보너스 (2등)
                Arguments.of(5, false, LottoRank.THIRD),  // 5개 일치 (3등)
                Arguments.of(4, false, LottoRank.FOURTH), // 4개 일치 (4등)
                Arguments.of(3, false, LottoRank.FIFTH),  // 3개 일치 (5등)
                Arguments.of(2, true, null),    // 2개 일치 (꽝)
                Arguments.of(0, false, null)   // 0개 일치 (꽝)
        );
    }

    @DisplayName("일치 갯수와 보너스 일치 여부에 따라 정확한 등수를 반환해야 한다.")
    @ParameterizedTest
    @MethodSource("rankData")
    void 정상_정확한_등수_반환(int matchCount, boolean matchBonus, LottoRank expectedRank) {
        // when
        LottoRank actualRank = LottoRank.valueOf(matchCount, matchBonus);

        // then
        assertThat(actualRank).isEqualTo(expectedRank);
    }

    @DisplayName("각 등수의 상금이 정확한지 확인한다.")
    @ParameterizedTest
    @MethodSource("prizeData")
    void 등수별_상금_검증(LottoRank rank, long expectedPrize) {
        assertThat(rank.getPrize()).isEqualTo(expectedPrize);
    }

    private static Stream<Arguments> prizeData() {
        return Stream.of(
                Arguments.of(LottoRank.FIRST, 2_000_000_000),
                Arguments.of(LottoRank.SECOND, 30_000_000),
                Arguments.of(LottoRank.THIRD, 1_500_000),
                Arguments.of(LottoRank.FOURTH, 50_000),
                Arguments.of(LottoRank.FIFTH, 5_000)
        );
    }
}
