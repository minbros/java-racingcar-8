package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.util.InputParser;
import racingcar.view.ConsoleView;

import java.util.List;

public class RacingController {
    private final ConsoleView view;
    private final RacingService service;

    public RacingController(ConsoleView view, RacingService service) {
        this.view = view;
        this.service = service;
    }

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
        for (int i = 0; i < count; i++) {
            service.playOneRound();
            view.printProgress(service.getCars());
        }
    }

    private void printWinners() {
        view.printResult(service.getWinningCars());
    }
}
