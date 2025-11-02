package lotto.config;

public enum ErrorMessage {
    EMPTY_NUMBER("[ERROR] 로또 번호에는 공백이 들어올 수 없습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1~45사이의 값이어야 합니다. "),
    INVALID_NUMBER_FORMAT("[ERROR] 로또 번호는 숫자만 들어와야 합니다."),
    INVALID_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    INVALID_PURCHASE_AMOUNT_FORMAT("[ERROR] 구입 금액은 숫자여야 합니다."),
    INVALID_PURCHASE_AMOUNT_POINT("[ERROR] 구입 금액은 1000단위어야 합니다."),
    INVALID_PURCHASE_AMOUNT_MIN("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
