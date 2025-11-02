package lotto.config;

public enum Information {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    RESULT_AMOUNT_FORMAT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INPUT_WINNING_STATISTICS("당첨 통계"),
    CONTOUR("---"),
    RESULT_WINNING_BASIC_FORMAT("%d개 일치 (%s원) - %d개"),
    RESULT_WINNING_SECOND_FORMAT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    PROFIT_RATE_FORMAT("총 수익률은 %.1f%%입니다."),
    NEW_LINE("\n");

    private final String information;
    Information (String information) {
        this.information = information;
    }

    public String getMessage() {
        return this.information;
    }
}
