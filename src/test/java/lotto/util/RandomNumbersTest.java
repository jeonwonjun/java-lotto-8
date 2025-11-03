package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.entity.BonusNumber;
import lotto.domain.entity.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RandomNumbersTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setup() {
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6);
        winningNumbers = new WinningNumbers(number, new BonusNumber(7, number));
    }

}
