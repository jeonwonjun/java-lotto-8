package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.io.Console;
import lotto.util.Information;

public class InputView {

    public static String readInput(String message) {
        System.out.println(message);
        return readLine();
    }
}
