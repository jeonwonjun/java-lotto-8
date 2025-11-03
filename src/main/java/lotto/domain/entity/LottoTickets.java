package lotto.domain.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoRank;
import lotto.util.RandomNumbers;

public class LottoTickets {
    private List<Lotto> tickets = new ArrayList<>();

    public void addTicket(Lotto ticket) {
        tickets.add(ticket);
    }

    public LottoResults aggregateLottoResults(WinningNumbers winningNumbers) {
        LottoResults lottoResults = new LottoResults();

        for (Lotto lotto : this.tickets) {
            int matchCount = lotto.countMatch(winningNumbers);
            boolean matchBonus = lotto.containsBonusNumber(winningNumbers);

            LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);
            lottoResults.addResult(rank);
        }

        return lottoResults;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
