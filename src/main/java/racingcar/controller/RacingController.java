package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.ConsoleView;

public class RacingController {
    private final ConsoleView view;
    private final RacingService service;

    public RacingController(ConsoleView view, RacingService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {

    }
}
