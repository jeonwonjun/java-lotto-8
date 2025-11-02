package lotto.controller;

import java.util.List;
import lotto.util.parser.BonusNumberParser;
import lotto.util.parser.PurchaseAmountParser;
import lotto.util.parser.WinningNumbersParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ViewController {
    public static int inputPurchaseAmount() {
        String input = InputView.readPurchaseAmount();
        return PurchaseAmountParser.parse(input);
    }

    public static List<Integer> inputWinningNumbers() {
        String input = InputView.readWinningNumber();
        return WinningNumbersParser.parse(input);
    }

    public static int inputBonusNumber() {
        String input = InputView.readBonusNumber();
        return BonusNumberParser.parse(input);
    }

    public static void printTickets(int ticketCount) {
        OutputView.printTicketCount(ticketCount);
    }
}
