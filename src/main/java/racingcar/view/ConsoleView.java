package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

/**
 * 사용자의 입력을 받거나 게임 진행 상황을 출력하는 클래스입니다.
 */
public class ConsoleView {
    private static final String PROMPT_FOR_NAMES =
            "경주할 자동차 이름을 입력하세요. (이름은 구분자(" + InputParser.NAME_SEPARATOR + ") 기준으로 구분)";
    private static final String PROMPT_FOR_COUNT = "시도할 횟수는 몇 회인가요?";

    /**
     * 사용자로부터 구분자를 기준으로 이름들을 입력받습니다.
     * <p>이름 규칙 관련 예외 처리는 진행하지 않으며, 입력 문법 관련 예외만 처리합니다.</p>
     *
     * @return 파싱한 이름 리스트
     * @throws IllegalArgumentException 이름의 구분이 잘못된 경우<br>
     *                                  예시: ",min,bros" 또는 "min,bros," 또는 "min,,bros"
     * @see InputParser#parseNames(String)
     */
    public List<String> readCarNames() {
        System.out.println(PROMPT_FOR_NAMES);
        return InputParser.parseNames(Console.readLine());
    }

    /**
     * 사용자로부터 게임 시행 횟수를 입력받습니다.
     *
     * @return 정수로 파싱한 횟수값
     * @throws IllegalArgumentException 입력받은 횟수가 다음과 같은 경우
     *                                  <ul>
     *                                      <li>양수가 아닌 경우</li>
     *                                      <li>int 범위를 벗어날 경우</li>
     *                                      <li>소수일 경우</li>
     *                                      <li>"two"와 같이 숫자를 사용하지 않은 표현일 경우</li>
     *                                  </ul>
     * @see InputParser#parseCount(String)
     */
    public int readCount() {
        System.out.println(PROMPT_FOR_COUNT);
        return InputParser.parseCount(Console.readLine());
    }

    /**
     * 게임이 시작될 때, 가독성을 높이기 위해 사용자의 입력과 게임 진행 상황을 분리합니다.
     */
    public void printStart() {
        System.out.println("\n실행 결과");
    }

    /**
     * 각 자동차마다 현재 위치를 포매팅하여 출력합니다.
     * <p>시행 횟수마다 빈 줄로 분리되어 출력합니다.</p>
     * <p>출력 예시
     * <pre><code>
     * min : ---
     * bros : -- </code></pre></p>
     *
     * @param cars 전체 자동차 리스트
     */
    public void printProgress(List<Car> cars) {
        for (Car car : cars) {
            String progress = getProgress(car);
            System.out.println(progress);
        }
        System.out.println();
    }

    /**
     * 최종 우승 자동차의 이름을 포매팅하여 출력합니다.
     * <p>공동 우승자가 존재할 경우, ", "로 구분되어 출력합니다.</p>
     * <p>
     * 출력 예시: {@code 최종 우승자 : min, bros}
     *
     * @param winningCars 우승한 자동차 리스트
     */
    public void printResult(List<Car> winningCars) {
        String message = "최종 우승자 : ";
        List<String> winningNames = winningCars.stream().map(Car::getName).toList();
        message += String.join(", ", winningNames);
        System.out.println(message);
    }

    private static String getProgress(Car car) {
        String name = car.getName();
        int position = car.getPosition();
        return name + " : " + "-".repeat(position);
    }
}
