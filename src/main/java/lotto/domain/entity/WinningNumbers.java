package lotto.domain.entity;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.record.LottoNumber;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> numbers, BonusNumber bonusNumber) {
        this.winningNumbers = converToLottoNumber(numbers);
        this.bonusNumber = bonusNumber;
    }

    private List<LottoNumber> converToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
