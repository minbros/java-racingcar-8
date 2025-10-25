package racingcar.service;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {
    private RacingService service;

    private static final int FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        service = new RacingService(new Cars());
    }

    @Test
    void 생성자_정상_확인() {
        assertThat(service.getCars()).isEmpty();
    }

    @Test
    void 자동차_추가_정상_확인() {
        Car car = new Car("min");

        service.addCar(car);

        assertThat(service.getCars()).containsOnly(car);
    }

    @Test
    void 우승자_정상_확인() {
        Car car1 = new Car("min", 3);
        Car car2 = new Car("bros", 4);

        service.addCar(car1);
        service.addCar(car2);

        assertThat(service.getWinningCars()).containsOnly(car2);
    }

    @Test
    void 게임_정상_진행_확인() {
        Car car1 = new Car("min");
        Car car2 = new Car("bros");

        service.addCar(car1);
        service.addCar(car2);

        Assertions.assertRandomNumberInRangeTest(() -> service.playOneRound(), FORWARD, STOP);
        assertThat(service.getCars().getFirst().getPosition()).isEqualTo(1);
        assertThat(service.getCars().get(1).getPosition()).isZero();
        assertThat(service.getWinningCars()).containsOnly(car1);
    }
}
