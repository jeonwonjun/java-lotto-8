package lotto.domain.record;

import static lotto.config.LottoConstants.MAX_RANGE;
import static lotto.config.LottoConstants.MIN_RANGE;

import lotto.config.ErrorMessage;

public record LottoNumber(int number) {

    public LottoNumber {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

}
