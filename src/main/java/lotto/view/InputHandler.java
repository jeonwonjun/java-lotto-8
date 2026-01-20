package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.config.ErrorMessage;
import lotto.model.BonusNumber;
import lotto.model.PurchaseAmount;

public class InputHandler {

    public PurchaseAmount readPurchaseAmount() {
        while (true) {
            try {
                String input = read();
                return new PurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
            }
        }
    }

    public Lotto readLottoNumber() {
        while (true) {
            try {
                String input = read();
                List<Integer> lottoNumber = parseToLottoNumber(input);
                return new Lotto(lottoNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BonusNumber readBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                String input = read();
                return new BonusNumber(winningNumber, input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseToLottoNumber(String input) {
        return Arrays.asList(input.split(","))
                .stream()
                .map(s -> Integer.parseInt(s.trim()))
                .toList();
    }

    private String read() {
        return readLine();
    }
}
