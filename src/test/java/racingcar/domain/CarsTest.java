package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private Cars cars;

    private static final int FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    void 자동차_정상_추가_확인() {
        Car car = new Car("min", 1);

        cars.add(car);

        assertThat(cars.get()).contains(car);
    }

    @Test
    void 자동차_추가_에러_확인() {
        Car car1 = new Car("min", 1);
        Car car2 = new Car("min", 3);

        cars.add(car1);

        assertThatThrownBy(() -> cars.add(car2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
    }

    @Test
    void 자동차_전체_이동_확인() {
        Car car1 = new Car("min");
        Car car2 = new Car("bros");

        cars.add(car1);
        cars.add(car2);
        cars.moveAll(List.of(FORWARD, STOP));
        List<Car> carList = cars.get();

        assertThat(carList.getFirst().getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isZero();
    }

    @Test
    void 자동차_전체_이동_예외_확인() {
        Car car1 = new Car("min");
        Car car2 = new Car("bros");

        cars.add(car1);
        cars.add(car2);
        List<Integer> randomValues = List.of(FORWARD, FORWARD, STOP);

        assertThatThrownBy(() -> cars.moveAll(randomValues))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_OF_RANDOM_VALUES_NOT_EQUALS_NUMBER_OF_CARS.getMessage());
    }
}
