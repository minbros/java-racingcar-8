package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class ConsoleView {
    private static final String PROMPT_FOR_NAMES =
            "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_FOR_COUNT = "시도할 횟수는 몇 회인가요?";

    public String readCarNames() {
        System.out.println(PROMPT_FOR_NAMES);
        return Console.readLine();
    }

    public String readCount() {
        System.out.println(PROMPT_FOR_COUNT);
        return Console.readLine();
    }

    public void printStart() {
        System.out.println("\n실행 결과");
    }

    public void printProgress(List<Car> cars) {
        for (Car car : cars) {
            String progress = getProgress(car);
            System.out.println(progress);
        }
        System.out.println();
    }

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
