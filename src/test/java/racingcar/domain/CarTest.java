package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 이름_공백_여부_확인() {
        String name = "  ";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_CANNOT_BE_BLANK.getMessage());
    }

    @Test
    void 이름_길이_확인() {
        String name = "minbros";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_CANNOT_BE_MORE_THAN_5_CHARACTERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"김민형", "min!!", "%%%", "m i n"})
    void 이름_정의되지_않은_문자_포함_여부_확인(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_MUST_CONTAIN_ONLY_ALPHABETS_AND_NUMBERS.getMessage());
    }

    @Test
    void 위치_양수_여부_확인() {
        int position = -1;

        assertThatThrownBy(() -> new Car("test", position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.POSITION_CANNOT_BE_NEGATIVE.getMessage());
    }

    @Test
    void 전진_성공_여부_확인() {
        int position = 2;
        Car car = new Car("test", position);

        car.move();

        assertThat(car.getPosition()).isEqualTo(position + 1);
    }
}
