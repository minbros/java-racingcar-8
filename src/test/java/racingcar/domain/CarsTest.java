package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    void 자동차_정상_추가_확인() {
        Cars cars = new Cars();
        Car car = new Car("min", 1);

        cars.add(car);

        assertThat(cars.get()).contains(car);
    }

    @Test
    void 자동차_추가_에러_확인() {
        Cars cars = new Cars();
        Car car1 = new Car("min", 1);
        Car car2 = new Car("min", 3);

        cars.add(car1);

        assertThatThrownBy(() -> cars.add(car2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
    }
}
