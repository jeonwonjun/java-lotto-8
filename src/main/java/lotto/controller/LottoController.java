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
    private final ViewController view;

    public LottoController(ViewController view) {
        this.view = view;
    }

    public void start() {
        PurchaseAmount purchaseAmount = view.inputPurchaseAmount();
        int ticketCount = purchaseAmount.getTicketCount();
        view.printTicketCount(ticketCount);

        LottoTickets lottoTickets = issueLottoTickets(ticketCount);

        WinningNumbers winningNumbers = getWinningNumbersFromUser();

        LottoResults lottoResults = lottoTickets.aggregateLottoResults(winningNumbers);

        view.printResults(lottoResults.getRankCounts());
        view.printProfit(lottoResults, (double) purchaseAmount.amount());
    }

    private LottoTickets issueLottoTickets(int ticketCount) {
        LottoTickets lottoTickets = new LottoTickets();

        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(RandomNumbers.generate());
            view.printTicket(lotto.getNumbers());
            lottoTickets.addTicket(lotto);
        }
        System.out.println();

        return lottoTickets;
    }

    private WinningNumbers getWinningNumbersFromUser() {
        Lotto winningNumber = view.inputWinningNumbers();
        BonusNumber bonusNumber = view.inputBonusNumber(winningNumber.getNumbers());
        return new WinningNumbers(winningNumber.getNumbers(), bonusNumber);
    }
}
