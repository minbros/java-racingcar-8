package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
