package lotto.controller;

import java.util.List;
import lotto.config.LottoRank;
import lotto.domain.entity.BonusNumber;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoResults;
import lotto.domain.entity.LottoTickets;
import lotto.domain.entity.WinningNumbers;
import lotto.domain.record.PurchaseAmount;
import lotto.util.RandomNumbers;

public class LottoController {

    public void start() {
        PurchaseAmount purchaseAmount = ViewController.inputPurchaseAmount();
        int ticketCount = purchaseAmount.getTicketCount();
        ViewController.printTicketCount(ticketCount);

        LottoTickets lottoTickets = issueLottoTickets(ticketCount);

        Lotto winningNumber = ViewController.inputWinningNumbers();
        BonusNumber bonusNumber = ViewController.inputBonusNumber(winningNumber.getNumbers());
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber.getNumbers(), bonusNumber);

        LottoResults lottoResults = aggregateLottoResults(lottoTickets, winningNumbers);

        ViewController.printResults(lottoResults.getRankCounts());
        ViewController.printProfit(purchaseAmount.amount());
    }

    private LottoTickets issueLottoTickets(int ticketCount) {
        LottoTickets lottoTickets = new LottoTickets();

        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(RandomNumbers.generate());

            ViewController.printTicket(lotto.getNumbers());

            lottoTickets.addTicket(lotto);
        }

        System.out.println();

        return lottoTickets;
    }

    private LottoResults aggregateLottoResults(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        LottoResults lottoResults = new LottoResults();

        for (Lotto lotto : lottoTickets.getTickets()) {
            int matchCount = lotto.countMatch(winningNumbers);
            boolean matchBonus = lotto.containsBonusNumber(winningNumbers);

            LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);
            lottoResults.addResult(rank);
        }

        return lottoResults;
    }
}
