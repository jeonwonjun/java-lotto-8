package lotto.config;

public enum ErrorMessage {
    INVALID_NUMBER_FORMAT("숫자가 입력되어야 합니다."),
    INVALID_PURCHASE_FORMAT("구입 금액은 1000원 단위로 나누어 떨어져야합니다."),
    INVALID_MIN_PURCHASE_AMOUNT("구입 금액은 최소 1000원 이상이어야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("당첨 번호는 6개의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_DUPLICATE("로또 번호는 중복되면 안됩니다.");

    private final String message;
    private static final String ERROR = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
