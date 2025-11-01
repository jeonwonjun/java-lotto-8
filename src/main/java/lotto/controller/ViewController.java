package lotto.controller;

import lotto.config.Information;
import lotto.view.InputView;

public class ViewController {

    public static String readPurchaseAmount() {
        return InputView.readInput(Information.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public static String readWinningNumber() {
        System.out.println();
        return InputView.readInput(Information.INPUT_WINNING_NUMBER.getMessage());
    }

    public static String readBonusNumber() {
        System.out.println();
        return InputView.readInput(Information.INPUT_BONUS_NUMBER.getMessage());
    }
}
