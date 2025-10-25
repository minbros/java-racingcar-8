package racingcar.constant;

public enum ErrorMessage {
    // Car 객체 생성자 관련
    NAME_CANNOT_BE_MORE_THAN_5_CHARACTERS("이름은 5자 이하여야 합니다."),
    NAME_CANNOT_BE_BLANK("이름은 공백일 수 없습니다."),
    NAME_MUST_CONTAIN_ONLY_ALPHABETS_AND_NUMBERS("이름에는 알파벳이나 숫자만 넣을 수 있습니다."),
    POSITION_CANNOT_BE_NEGATIVE("위치 값이 음수일 수 없습니다."),

    // Cars 객체 관련
    DUPLICATE_CAR_NAMES("자동차 이름은 중복될 수 없습니다."),
    NUMBER_OF_RANDOM_VALUES_NOT_EQUALS_NUMBER_OF_CARS("자동차의 개수와 랜덤 값의 개수가 다릅니다."),

    // InputParser 객체 관련
    COUNT_IS_NOT_IN_INT_RANGE("횟수가 int 범위에 맞지 않습니다."),
    INVALID_NAME_FORMAT("이름 구분자의 위치가 잘못되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
