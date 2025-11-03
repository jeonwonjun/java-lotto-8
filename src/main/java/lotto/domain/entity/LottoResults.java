package lotto.domain.entity;

import java.util.EnumMap;
import java.util.Map;
import lotto.config.LottoRank;

public class LottoResults {
    private static final int MATCH_FIVE = 5;
    private final Map<LottoRank, Integer> rankCounts;

    public LottoResults() {
        this.rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addResult(LottoRank rank) {
        if (rank != null) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    public double calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(double purchaseAmount) {
        double totalPrize = calculateTotalPrize();
        return (totalPrize / purchaseAmount) * 100.0;
    }

    public int getRankCount(LottoRank rank) {
        return rankCounts.get(rank);
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }
}
