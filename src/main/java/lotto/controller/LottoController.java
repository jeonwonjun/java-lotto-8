package lotto.controller;

import java.util.List;
import lotto.config.LottoRank;
import lotto.domain.entity.BonusNumber;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoResults;
import lotto.domain.entity.LottoTickets;
import lotto.domain.entity.WinningNumbers;
import lotto.domain.record.PurchaseAmount;
import lotto.util.PrizeCalculator;
import lotto.util.RandomNumbers;

public class LottoController {

    public void start() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(ViewController.inputPurchaseAmount());
        int ticketCount = purchaseAmount.getTicketCount();
        ViewController.printTicketCount(ticketCount);

        LottoTickets lottoTickets = issueLottoTickets(ticketCount);

        Lotto winningNumber = new Lotto(ViewController.inputWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(ViewController.inputBonusNumber(), winningNumber.getNumbers());
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber.getNumbers(), bonusNumber);

        LottoResults lottoResults = aggregateLottoResults(lottoTickets, winningNumbers);

        double totalResult = PrizeCalculator.calculate(lottoResults.getRankCounts());
        ViewController.printResults(lottoResults.getRankCounts());
        ViewController.printProfit(totalResult, (double) purchaseAmount.amount());
    }

    private LottoTickets issueLottoTickets(int ticketCount) {
        LottoTickets lottoTickets = new LottoTickets();

        for (int i = 0; i < ticketCount; i++) {
            RandomNumbers randomNumbers = new RandomNumbers();

            ViewController.printTicket(randomNumbers.getLottoTicket());

            lottoTickets.addTicket(randomNumbers);
        }

        System.out.println();

        return lottoTickets;
    }

    private LottoResults aggregateLottoResults(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        LottoResults lottoResults = new LottoResults();

        for (RandomNumbers randomNumbers : lottoTickets.getTickets()) {
            int matchCount = randomNumbers.countMatch(winningNumbers);
            boolean matchBonus = randomNumbers.matchBonusNumber(winningNumbers);

            LottoRank rank = LottoResults.findRankByMatchBonus(matchCount, matchBonus);
            lottoResults.addResult(rank);
        }

        return lottoResults;
    }
}
