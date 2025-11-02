package lotto.view;

import java.util.Map;
import lotto.config.Information;
import lotto.config.LottoRank;

public class PrintFormat {

    public static String profitFormat(double profitRate) {
        return String.format(Information.PROFIT_RATE_FORMAT.getMessage(), profitRate);
    }

    public static String resultFormat(int prize) {
        return String.format("%,d", prize);
    }

    public static String ticketCountFormat(int ticketCount) {
        return String.format(Information.RESULT_AMOUNT_FORMAT.getMessage(), ticketCount);
    }

    public static String secondRankFormat(LottoRank rank, Map<LottoRank, Integer> rankCounts) {
        return String.format(Information.RESULT_WINNING_SECOND_FORMAT.getMessage(),
                rank.getMatchCount(),
                resultFormat(rank.getPrize()),
                rankCounts.get(rank));
    }

    public static String RankFormat(LottoRank rank, Map<LottoRank, Integer> rankCounts) {
        return String.format(Information.RESULT_WINNING_BASIC_FORMAT.getMessage(),
                rank.getMatchCount(),
                resultFormat(rank.getPrize()),
                rankCounts.get(rank));
    }
}
