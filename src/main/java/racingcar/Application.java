package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        RacingService racingService = new RacingService();
        RacingController racingController = new RacingController(consoleView, racingService);
        racingController.run();
    }
}
