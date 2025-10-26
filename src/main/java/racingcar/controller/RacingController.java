package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.util.InputParser;
import racingcar.view.ConsoleView;

import java.util.List;

/**
 * 자동차 경주 게임의 전체 흐름을 제어하는 컨트롤러입니다.
 * <p>
 *     사용자 입력을 받아 도메인과 뷰를 연결하며, 게임 시작부터 결과 출력까지 모든 과정을 담당합니다.
 * </p>
 * <ul>
 *     <li>view: 사용자 입출력 담당</li>
 *     <li>service: 게임 로직 처리 담당</li>
 * </ul>
 * @see RacingService
 * @see ConsoleView
 */
public class RacingController {
    private final ConsoleView view;
    private final RacingService service;

    public RacingController(ConsoleView view, RacingService service) {
        this.view = view;
        this.service = service;
    }

    /**
     * 자동차 경주 앱을 실행합니다.
     * @throws IllegalArgumentException 사용자 입력이 잘못되었을 경우
     */
    public void run() {
        List<String> names = getCarNamesFromUser();
        int count = getTryCountFromUser();
        registerCars(names);
        playRounds(count);
        printWinners();
    }

    private List<String> getCarNamesFromUser() {
        String namesInput = view.readCarNames();
        return InputParser.parseNames(namesInput);
    }

    private int getTryCountFromUser() {
        String countInput = view.readCount();
        return InputParser.parseCount(countInput);
    }

    private void registerCars(List<String> names) {
        names.forEach(name -> service.addCar(new Car(name)));
    }

    private void playRounds(int count) {
        view.printStart();
        for (int i = 0; i < count; i++) {
            service.playOneRound();
            view.printProgress(service.getCars());
        }
    }

    private void printWinners() {
        view.printResult(service.getWinningCars());
    }
}
