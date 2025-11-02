package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.config.Information;
import lotto.config.LottoRank;
import lotto.domain.record.PurchaseAmount;
import lotto.util.RandomNumbers;

public class OutputView {

    public static void printPurchaseAmountPrompt() {
        printMessage(Information.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public static void printWinningNumberPrompt() {
        printMessage(Information.INPUT_WINNING_NUMBER.getMessage());
    }

    public static void printBonusNumberPrompt() {
        printMessage(Information.INPUT_BONUS_NUMBER.getMessage());
    }

    public static void printTicketCount(int ticketCount) {
        printMessage(PrintFormat.ticketCountFormat(ticketCount));
    }

    public static void printLottoTicket(List<Integer> lottoTicket) {
        System.out.println(lottoTicket);
    }

    public static void printWinningResults(Map<LottoRank, Integer> rankCounts) {
        System.out.println(Information.INPUT_WINNING_STATISTICS.getMessage());
        System.out.println(Information.CONTOUR.getMessage());
        rankCounts.entrySet().stream()
                .forEach(entry -> {
                    LottoRank rank = entry.getKey();
                    int count = entry.getValue();

                    if (rank == LottoRank.SECOND) {
                        System.out.println(PrintFormat.secondRankFormat(rank, rankCounts));
                    }

                    if (rank != LottoRank.SECOND) {
                        System.out.println(PrintFormat.RankFormat(rank, rankCounts));
                    }
                });
    }

    public static void printProfitRate(double profitRate) {
        printMessage(PrintFormat.profitFormat(profitRate));
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

}
