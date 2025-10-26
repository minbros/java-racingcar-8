package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.regex.Pattern;

/**
 * 경주에 사용되는 자동차 객체입니다.
 * <ul>
 *     <li>name: 자동차 이름</li>
 *     <li>position: 자동차의 현재 위치 (기본값 0)</li>
 * </ul>
 */
public class Car {
    private final String name;
    private int position;

    // 이름 검증에 사용되는 패턴
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    // 이동 기준값 및 이름 길이 제한값
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;

    /**
     * @throws IllegalArgumentException <ul>
     *                                  <li>이름이 null이거나 공백인 경우</li>
     *                                  <li>이름이 {@value #MAX_NAME_LENGTH}자를 초과한 경우</li>
     *                                  <li>이름에 영문/숫자 이외의 문자가 포함된 경우</li>
     *                                  </ul>
     */
    public Car(String name) {
        this(name, 0);
    }

    /**
     * 테스트 코드용 생성자입니다. 초기 위치를 설정할 수 있습니다.
     *
     * @throws IllegalArgumentException <ul>
     *                                  <li>이름이 null이거나 공백인 경우</li>
     *                                  <li>이름이 {@value #MAX_NAME_LENGTH}자를 초과한 경우</li>
     *                                  <li>이름에 영문/숫자 이외의 문자가 포함된 경우</li>
     *                                  <li>위치 값이 음수인 경우</li>
     *                                  </ul>
     *
     */
    public Car(String name, int position) {
        validateName(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    /**
     * 랜덤 값이 {@value #MOVE_THRESHOLD} 이상이면 이동합니다.
     *
     * @param randomValue 자동차 이동을 결정하는 랜덤 값
     */
    public void move(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_CANNOT_BE_BLANK.getMessage());
        }
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MUST_CONTAIN_ONLY_ALPHABETS_AND_NUMBERS.getMessage());
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_CANNOT_BE_MORE_THAN_5_CHARACTERS.getMessage());
        }
    }

    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_CANNOT_BE_NEGATIVE.getMessage());
        }
    }
}
