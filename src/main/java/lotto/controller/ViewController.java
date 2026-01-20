package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.PurchaseAmount;
import lotto.model.Rank;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class ViewController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public ViewController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public PurchaseAmount purchaseInput() {
        outputHandler.printPurchaseInfo();
        return inputHandler.readPurchaseAmount();
    }

    public void ticketsOutput(LottoTickets lottoTickets, int purchaseCount) {
        outputHandler.printTicketCount(purchaseCount);
        for (Lotto ticket : lottoTickets.getTickets()) {
            outputHandler.printTickets(ticket.getNumbers());
        }
    }

    public Lotto winningNumberInput() {
        outputHandler.printWinningNumberInfo();
        return inputHandler.readLottoNumber();
    }

    public BonusNumber bonusNumberInput(List<Integer> winningNumber) {
        outputHandler.printBonusNumberInfo();
        return inputHandler.readBonusNumber(winningNumber);
    }

    public void analyzeOutput(Rank rank) {
        outputHandler.printAnalyzeWinning(rank.getRank());
    }

    public void profitOutput(double profit) {
        outputHandler.printProfit(profit);
    }
}
