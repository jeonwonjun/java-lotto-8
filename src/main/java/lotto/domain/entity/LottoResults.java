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

    public static LottoRank findRankByMatchBonus(int matchCount, boolean matchBonus) {
        if (matchCount == MATCH_FIVE && matchBonus) {
            return LottoRank.SECOND;
        }

        return findRankByMatchCount(matchCount);
    }

    private static LottoRank findRankByMatchCount(int matchCount) {
        for (LottoRank rank : LottoRank.values()) {
            if (matchCount == rank.getMatchCount()) {
                return rank;
            }
        }
        return null;
    }

    public void addResult(LottoRank rank) {
        if (rank != null) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    public int getRankCount(LottoRank rank) {
        return rankCounts.get(rank);
    }

    public Map<LottoRank, Integer> getRankCounts() {
        return rankCounts;
    }
}
