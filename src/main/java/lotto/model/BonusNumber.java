package lotto.model;

import java.util.List;
import lotto.config.ErrorMessage;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(List<Integer> winningNumber, String bonusInput) {
        this.bonus = parseToBonus(winningNumber, bonusInput);
    }

    private int parseToBonus(List<Integer> winningNumber, String bonusInput) {
        int bonus = Integer.parseInt(bonusInput);
        validate(winningNumber, bonus);
        return bonus;
    }

    private void validate(List<Integer> winningNumber, int bonus) {
        validateFormat(bonus);
        validateDuplicate(winningNumber, bonus);
    }

    private void validateFormat(int bonus) {
        if (bonus < Lotto.LOTTO_NUMBER_MIN || bonus > Lotto.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> lotto, int bonus) {
        for (int number : lotto) {
            if (number == bonus) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATE.getMessage());
            }
        }
    }

    public int getBonus() {
        return bonus;
    }
}
