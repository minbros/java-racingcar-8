package racingcar.view;

import racingcar.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;

/**
 * 유저 입력을 검증하는 유틸리티 클래스입니다.
 */
final class InputParser {
    private InputParser() {
    }

    // 이름 구분자
    static final String NAME_SEPARATOR = ",";

    /**
     * 입력받은 문자열을 {@value #NAME_SEPARATOR}를 기준으로 구분합니다.
     * <p>이름 양 옆의 공백은 모두 지워집니다.</p>
     *
     * @return 구분된 이름 리스트
     * @throws IllegalArgumentException 이름의 구분이 잘못된 경우<br>
     *                                  예시: ",min,bros" 또는 "min,bros," 또는 "min,,bros"
     */
    static List<String> parseNames(String input) {
        List<String> names = Arrays.stream(input.split(NAME_SEPARATOR, -1))
                .map(String::trim)
                .toList();

        if (names.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_FORMAT.getMessage());
        }

        return names;
    }

    /**
     * 입력받은 문자열을 경기 횟수로 변환합니다.
     * <p>횟수 양 옆의 공백은 모두 지워집니다.</p>
     *
     * @return 정수로 변환된 경기 횟수
     * @throws IllegalArgumentException 입력받은 횟수가 다음과 같은 경우
     *                                  <ul>
     *                                      <li>양수가 아닌 경우</li>
     *                                      <li>int 범위를 벗어날 경우</li>
     *                                      <li>소수일 경우</li>
     *                                      <li>"two"와 같이 숫자를 사용하지 않은 표현일 경우</li>
     *                                  </ul>
     */
    static int parseCount(String input) {
        String trimmedInput = input.trim();
        try {
            int count = Integer.parseInt(trimmedInput);
            if (count <= 0) throw new IllegalArgumentException(ErrorMessage.COUNT_MUST_BE_POSITIVE.getMessage());
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_IS_NOT_IN_INT_RANGE.getMessage());
        }
    }
}
