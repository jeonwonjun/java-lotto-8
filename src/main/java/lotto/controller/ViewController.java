package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.config.LottoRank;
import lotto.util.ProfitRateCalculator;
import lotto.util.parser.WinningNumbersParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ViewController {
    public static int inputPurchaseAmount() {
        return InputView.inputPurchaseAmount();
    }

    public static List<Integer> inputWinningNumbers() {
        String input = InputView.inputWinningNumbers();
        System.out.println();
        return WinningNumbersParser.parse(input);
    }

    public static int inputBonusNumber() {
        return InputView.inputBonusNumber();
    }

    public static void printTicketCount(int ticketCount) {
        OutputView.printTicketCount(ticketCount);
    }

    public static void printTicket(List<Integer> randomNumbers) {
        OutputView.printLottoTicket(randomNumbers);
    }

    public static void printResults(Map<LottoRank, Integer> rankCounts) {
        OutputView.printWinningResults(rankCounts);
    }

    public static void printProfit(double purchaseAmount, double totalPrize) {
        double profitRate = ProfitRateCalculator.calculate(purchaseAmount, totalPrize);
        OutputView.printProfitRate(profitRate);
    }
}
