package racingcar.service;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class RacingServiceTest {
    private RacingService service;

    private static final int FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        service = new RacingService(new Cars());
    }

    @Test
    void 자동차_추가_정상_확인() {
        String name = "min";

        service.addCar(name);
        List<Car> cars = service.getCars();

        assertThat(cars).extracting(Car::getName, Car::getPosition)
                .containsExactly(tuple(name, 0));
    }

    @Test
    void 우승자_정상_확인() {
        String name1 = "min";
        int position1 = 3;
        String name2 = "bros";
        int position2 = 4;

        service.addCar(name1, position1);
        service.addCar(name2, position2);
        List<Car> winningCars = service.getWinningCars();

        assertThat(winningCars).extracting(Car::getName, Car::getPosition)
                .containsExactly(tuple(name2, position2));
    }

    @Test
    void 게임_정상_진행_확인() {
        String name1 = "min";
        String name2 = "bros";

        service.addCar(name1);
        service.addCar(name2);

        Assertions.assertRandomNumberInRangeTest(() -> service.playOneRound(), FORWARD, STOP);
        assertThat(service.getCars()).extracting(Car::getName, Car::getPosition)
                .containsExactly(tuple(name1, 1), tuple(name2, 0));
        assertThat(service.getWinningCars()).extracting(Car::getName, Car::getPosition)
                .containsExactly(tuple(name1, 1));
    }
}
