package lotto.domain.entity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import lotto.config.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoResultsTest {

    private LottoResults lottoResults;

    @DisplayName("등수별 갯수를 정확하게 누적해야 한다.")
    @Test
    void 등수별_갯수_누적() {
        // given
        LottoResults results = new LottoResults();

        // when
        results.addResult(LottoRank.FIRST);
        results.addResult(LottoRank.THIRD);
        results.addResult(LottoRank.THIRD);
        results.addResult(LottoRank.FIFTH);
        results.addResult(null);

        // then
        assertThat(results.getRankCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(results.getRankCount(LottoRank.THIRD)).isEqualTo(2);
        assertThat(results.getRankCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(results.getRankCount(null)).isEqualTo(0);
    }

    @DisplayName("누적된 결과를 바탕으로 총 상금을 정확히 계산해야 한다.")
    @Test
    void 총상금_계산() {
        // given
        LottoResults results = new LottoResults();

        results.addResult(LottoRank.FIRST);
        results.addResult(LottoRank.THIRD);
        results.addResult(LottoRank.THIRD);
        results.addResult(LottoRank.FIFTH);

        double expectedTotalPrize = 2_003_005_000.0;

        // when
        double actualTotalPrize = results.calculateTotalPrize();

        // then
        assertEquals(expectedTotalPrize, actualTotalPrize, 0.001);
    }

    @DisplayName("총 상금과 구입 금액을 바탕으로 수익률을 정확히 계산해야 한다.")
    @Test
    void 수익률_계산() {
        // given
        LottoResults results = new LottoResults();
        int purchaseAmount = 8000;

        results.addResult(LottoRank.FIFTH);

        double expectedProfitRate = 62.5;

        // when
        double actualProfitRate = results.calculateProfitRate(purchaseAmount);

        // then
        assertEquals(expectedProfitRate, actualProfitRate, 0.001);
    }

}
