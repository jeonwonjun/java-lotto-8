package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.config.LottoRank;
import lotto.domain.entity.BonusNumber;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoResults;
import lotto.domain.record.PurchaseAmount;
import lotto.util.WinningNumbersParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ViewController {
    public PurchaseAmount inputPurchaseAmount() {
        PurchaseAmount purchaseAmount = null;
        OutputView.printPurchaseAmountPrompt();
        while (purchaseAmount == null) {
            try {
                int amount = InputView.inputPurchaseAmount();
                purchaseAmount = new PurchaseAmount(amount);
                System.out.println();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    public Lotto inputWinningNumbers() {
        Lotto winningNumbers = null;
        OutputView.printWinningNumberPrompt();
        while (winningNumbers == null) {
            try {
                String input = InputView.inputWinningNumbers();
                winningNumbers = new Lotto(WinningNumbersParser.parse(input));
                System.out.println();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public BonusNumber inputBonusNumber(List<Integer> winningNumbers) {
        BonusNumber bonusNumber = null;
        OutputView.printBonusNumberPrompt();
        while (bonusNumber == null) {
            try {
                int bonus = InputView.inputBonusNumber();
                bonusNumber = new BonusNumber(bonus, winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public void printTicketCount(int ticketCount) {
        OutputView.printTicketCount(ticketCount);
    }

    public void printTicket(List<Integer> randomNumbers) {
        OutputView.printLottoTicket(randomNumbers);
    }

    public void printResults(Map<LottoRank, Integer> rankCounts) {
        OutputView.printWinningResults(rankCounts);
    }

    public void printProfit(LottoResults lottoResults, double purchaseAmount) {
        OutputView.printProfitRate(lottoResults.calculateProfitRate(purchaseAmount));
    }
}
