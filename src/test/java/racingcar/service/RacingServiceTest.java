package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {
    private RacingService service;

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
}
