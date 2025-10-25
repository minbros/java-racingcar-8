package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;
import racingcar.domain.Cars;
import racingcar.service.RacingService;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        RacingService racingService = new RacingService(new Cars());
        RacingController racingController = new RacingController(consoleView, racingService);
        racingController.run();
        Console.close();
    }
}
