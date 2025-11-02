package lotto.domain.entity;

import static lotto.config.LottoConstants.MAX_RANGE;
import static lotto.config.LottoConstants.MIN_RANGE;

import java.util.List;
import lotto.config.ErrorMessage;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number, List<Integer> numbers) {
        validate(number, numbers);
        this.number = number;
    }

    private void validate(int number, List<Integer> numbers) {
        validateNumberRange(number);
        validateNumberDuplicate(number, numbers);
    }

    private void validateNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateNumberDuplicate(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.getMessage());
        }
    }

    public int getNumber() {
        return this.number;
    }
}