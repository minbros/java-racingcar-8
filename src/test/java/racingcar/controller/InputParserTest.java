package racingcar.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {
    @Test
    void 이름_파싱_확인() {
        String input = "min,bros";

        List<String> names = InputParser.parseNames(input);

        assertThat(names).containsOnly("min", "bros");
    }

    @Test
    void 횟수_파싱_확인() {
        String input = "10";

        int count = InputParser.parseCount(input);

        assertThat(count).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"two", "2.4", "100000000000"})
    void 횟수_파싱_예외_확인(String input) {
        assertThatThrownBy(() -> InputParser.parseCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COUNT_IS_NOT_IN_INT_RANGE.getMessage());
    }
}
