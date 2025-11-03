package lotto.domain.record;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @DisplayName("구입금액은 1000단위로 입력되어야 한다.")
    @Test
    void 예외_구입금액_단위() {
        int purchaseAmount = 2500;

        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(purchaseAmount));
    }

    @DisplayName("구입금액이 1000의 배수면 통과")
    @Test
    void 정상_구입금액_단위() {
        int purchaseAmount = 3000;

        assertDoesNotThrow(() -> new PurchaseAmount(purchaseAmount));
    }

    @DisplayName("최소 금액은 1000원 이상이어야한다.")
    @Test
    void 예외_구입금액_최소() {
        int purchaseAmount = 700;

        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(purchaseAmount));
    }
}
