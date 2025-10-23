package racingcar.constant;

public enum ErrorMessage {
    // Car 객체 생성자 관련
    NAME_CANNOT_BE_MORE_THAN_5_CHARACTERS("이름은 5자 이하여야 합니다."),
    NAME_CANNOT_BE_NULL_OR_BLANK("이름이 비어 있거나 공백일 수 없습니다."),
    NAME_MUST_CONTAIN_ONLY_ALPHABETS_AND_NUMBERS("이름에는 알파벳이나 숫자만 넣을 수 있습니다."),
    POSITION_CANNOT_BE_NEGATIVE("위치 값이 음수일 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
