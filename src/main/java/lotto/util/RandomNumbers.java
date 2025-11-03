package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.LottoConstants;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.WinningNumbers;

public class RandomNumbers {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_RANGE, LottoConstants.MAX_RANGE, LottoConstants.LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
