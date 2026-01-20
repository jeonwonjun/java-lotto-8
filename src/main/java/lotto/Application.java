package lotto;

import lotto.controller.LottoRetailer;
import lotto.controller.ViewController;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        ViewController view = new ViewController(inputHandler, outputHandler);

        LottoRetailer lottoRetailer = new LottoRetailer(view);
        lottoRetailer.start();
    }
}
