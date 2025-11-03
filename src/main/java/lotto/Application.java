package lotto;

import lotto.controller.LottoController;
import lotto.controller.ViewController;

public class Application {
    public static void main(String[] args) {
        ViewController view = new ViewController();

        LottoController lottoController = new LottoController(view);
        lottoController.start();
    }
}
