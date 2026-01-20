package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Predicate;
import lotto.config.RankInfo;

public class Rank {
    private final EnumMap<RankInfo, Integer> rankCounts;

    public Rank() {
        this.rankCounts = new EnumMap<>(RankInfo.class);
        for (RankInfo rank : RankInfo.values()) {
            rankCounts.put(rank, 0);
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

    public void analyzeRank(List<Lotto> lottoTickets, WinningNumber winningNumber) {
        for (Lotto ticket : lottoTickets) {
            int matchCount = matchTicket(ticket, winningNumber.getWinningNumber());
            boolean bonus = matchBonus(ticket.getNumbers(), winningNumber.getBonusNumber().getBonus());
            addMap(matchCount, bonus);
        }
    }

    private void addMap(int matchCount, boolean bonus) {
        if (matchCount == RankInfo.FIRST.getCount()) {
            rankCounts.put(RankInfo.FIRST, rankCounts.getOrDefault(RankInfo.FIRST, 0) + 1);
        }

        if (matchCount == RankInfo.SECOND.getCount() && bonus) {
            rankCounts.put(RankInfo.SECOND, rankCounts.getOrDefault(RankInfo.SECOND, 0) + 1);
            return;
        }

        if (matchCount == RankInfo.THIRD.getCount()) {
            rankCounts.put(RankInfo.THIRD, rankCounts.getOrDefault(RankInfo.THIRD, 0) + 1);
        }

        if (matchCount == RankInfo.FOURTH.getCount()) {
            rankCounts.put(RankInfo.FOURTH, rankCounts.getOrDefault(RankInfo.FOURTH, 0) + 1);
        }

        if (matchCount == RankInfo.FIFTH.getCount()) {
            rankCounts.put(RankInfo.FIFTH, rankCounts.getOrDefault(RankInfo.FIFTH, 0) + 1);
        }

    }

    private int matchTicket(Lotto ticket, Lotto winningNumber) {
        List<Integer> winningTicket = winningNumber.getNumbers();
        List<Integer> newTicket = ticket.getNumbers();

        List<Integer> matchList = winningTicket.stream()
                .filter(o -> newTicket.stream()
                        .anyMatch(Predicate.isEqual(o)))
                .toList();
        return matchList.size();
    }

    private boolean matchBonus(List<Integer> ticket, int bonusNumber) {
        for (int number : ticket) {
            if (number == bonusNumber) {
                return true;
            }
        }

        return false;
    }

    public EnumMap<RankInfo, Integer> getRank() {
        return rankCounts;
    }
}
