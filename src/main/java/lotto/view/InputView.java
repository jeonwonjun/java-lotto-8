package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.OutputView.printMessage;

import lotto.config.ErrorMessage;
import lotto.config.Information;
import lotto.util.parser.InputValidator;

public class InputView {

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                return InputValidator.validate(readInput());
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    public static String inputWinningNumbers() {
        while (true) {
            try {
                return readInput();
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            try {
                return InputValidator.validate(readInput());
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        }
    }

    private static String readInput() {
        return readLine();
    }
}
