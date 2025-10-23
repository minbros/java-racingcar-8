package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    void 정상_생성_확인() {
        String name = "min";

        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 테스트용_생성_확인() {
        String name = "min";
        
        Car car = new Car(name, 3);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
