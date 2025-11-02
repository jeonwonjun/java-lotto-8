package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.config.Information;

public class InputView {

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

    private static String readInput(String message) {
        System.out.println(message);
        return readLine();
    }
}
