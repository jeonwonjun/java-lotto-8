package lotto.domain.entity;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.record.LottoNumber;
import lotto.util.WinningNumbersParser;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(String input, BonusNumber bonusNumber) {
        this.winningNumbers = converToLottoNumber(input);
        this.bonusNumber = bonusNumber;
    }

    private List<LottoNumber> converToLottoNumber(String input) {
        List<Integer> splitNumbers = WinningNumbersParser.parse(input);
        return splitNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
