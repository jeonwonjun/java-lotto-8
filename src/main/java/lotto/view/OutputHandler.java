package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.config.RankInfo;

public class OutputHandler {
    public void printPurchaseInfo() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicketCount(int purchaseCount) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseCount);
    }

    public void printTickets(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printWinningNumberInfo() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInfo() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printAnalyzeWinning(EnumMap<RankInfo, Integer> rank) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        rank.forEach((k, v) -> {
            System.out.printf(k.getFormat(), v);
            System.out.println();
        });
    }

    public void printProfit(double profit) {
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", profit);
    }
}