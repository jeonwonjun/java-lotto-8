package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.config.ErrorMessage;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumber(List<Integer> lottoNumber) {
        validateLottoNumberCount(lottoNumber);
        validateLottoNumberRange(lottoNumber);
        validateLottoNumberDuplicate(lottoNumber);
    }

    private void validateLottoNumberCount(List<Integer> lottoNumber) {
        if (lottoNumber.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateLottoNumberRange(List<Integer> lottoNumber) {
        for (int number : lottoNumber) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateLottoNumberDuplicate(List<Integer> lottoNumber) {
        if (lottoNumber.size() != lottoNumber.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
