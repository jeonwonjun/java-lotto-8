package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoTickets;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;
import lotto.model.WinningNumber;

public class LottoRetailer {
    private final ViewController view;

    public LottoRetailer(ViewController view) {
        this.view = view;
    }

    public void start() {

        PurchaseAmount purchaseAmount = view.purchaseInput();

        LottoTickets lottoTickets = new LottoTickets();
        issuedTickets(lottoTickets, purchaseAmount.getTicketAmount());
        view.ticketsOutput(lottoTickets, purchaseAmount.getTicketAmount());

        Lotto winning = view.winningNumberInput();
        BonusNumber bonusNumber = view.bonusNumberInput(winning.getNumbers());

        WinningNumber winningNumber = new WinningNumber(winning, bonusNumber);

        Rank rank = new Rank();
        rank.analyzeRank(lottoTickets.getTickets(), winningNumber);

        view.analyzeOutput(rank);

        view.profitOutput(rank.calculateProfitRate(purchaseAmount.getPurchaseAmount()));
    }

    private void issuedTickets(LottoTickets tickets, int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            tickets.addTicket(new Lotto(LottoGenerator.generate()));
        }
    }
}
