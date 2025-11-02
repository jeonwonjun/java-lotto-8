package lotto.domain.record;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.util.parser.InputValidator;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @DisplayName("구입금액은 1000단위로 입력되어야 한다.")
    @Test
    void 구입금액단위_예외() {
        int purchaseAmount = 2500;

        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(purchaseAmount));
    }

    @DisplayName("구입금액이 1000의 배수면 통과")
    @Test
    void 구입금액단위_정상() {
        int purchaseAmount = 3000;

        assertDoesNotThrow(() -> new PurchaseAmount(purchaseAmount));
    }

    @DisplayName("최소 금액은 1000원 이상이어야한다.")
    @Test
    void 구입금액_예외_최소() {
        int purchaseAmount = 700;

        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(purchaseAmount));
    }

    @DisplayName("구입금액에는 공백이 들어오면 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"8 000", " 8000", "8000 "})
    void 구입금액_예외_공백(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));
    }
}
