package lotto.model;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int COUNT = 6;


    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
