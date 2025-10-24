package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 자동차_정상_추가_확인() {
        Cars cars = new Cars();
        Car car = new Car("min", 1);

        cars.add(car);

        assertThat(cars.get()).contains(car);
    }
}
