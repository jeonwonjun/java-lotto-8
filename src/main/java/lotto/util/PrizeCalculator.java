package lotto.util;

import java.util.Map;
import lotto.config.LottoRank;

public class PrizeCalculator {

    public static double calculate(Map<LottoRank, Integer> lottoResults) {
        return lottoResults.entrySet().stream()
                .mapToDouble(entry -> {
                    LottoRank lottoRank = entry.getKey();
                    int count = entry.getValue();
                    return lottoRank.getPrize() * count;
                })
                .sum();
    }
}
