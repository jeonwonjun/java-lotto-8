package lotto.controller;

import lotto.config.Information;
import lotto.util.BonusNumberParser;
import lotto.util.PurchaseAmountParser;
import lotto.view.InputView;

public class ViewController {
    public static int inputPurchaseAmount() {
        String input = InputView.readPurchaseAmount();
        return PurchaseAmountParser.parse(input);
    }

    public static int inputBonusNumber() {
        String input = InputView.readBonusNumber();
        return BonusNumberParser.parse(input);
    }
}
