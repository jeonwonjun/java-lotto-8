package lotto.domain.entity;

import static lotto.config.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.config.LottoConstants.MAX_RANGE;
import static lotto.config.LottoConstants.MIN_RANGE;

import java.util.List;
import lotto.config.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersRange(numbers);
        validateNumberDuplicate(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream().distinct().count();
        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.getMessage());
        }
    }
}
