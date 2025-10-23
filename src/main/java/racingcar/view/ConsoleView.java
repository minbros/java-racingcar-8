package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class ConsoleView {
    private static final String PROMPT_FOR_NAMES =
            "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분";

    public String readCarNames() {
        System.out.println(PROMPT_FOR_NAMES);
        return Console.readLine();
    }

    public void printProgress(List<Car> cars) {

    }

    public void printResult(List<Car> winners) {

    }
}
