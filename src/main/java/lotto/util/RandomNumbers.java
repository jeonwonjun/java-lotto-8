package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.LottoConstants;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.WinningNumbers;

public class RandomNumbers {
    private final List<Integer> lottoTicket;

    public RandomNumbers() {
        this.lottoTicket = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_RANGE, LottoConstants.MAX_RANGE, LottoConstants.LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int countMatch(WinningNumbers winningNumbers) {
        int matchCount = 0;

        for (int myNumber : lottoTicket) {
            if (winningNumbers.contains(myNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean matchBonusNumber (WinningNumbers winningNumbers) {
        int matchCount = countMatch(winningNumbers);
        if (matchCount == LottoConstants.THIRD_RANK_MATCH_COUNT) {
            return lottoTicket.contains(winningNumbers.getBonusNumber());
        }
        return false;
    }

    public List<Integer> getLottoTicket() {
        return lottoTicket;
    }
}
