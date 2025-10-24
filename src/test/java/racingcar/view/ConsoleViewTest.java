package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleViewTest {
    private ConsoleView view;
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        view = new ConsoleView();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void 이름_및_횟수_입력받기() {
        String input = "hi,min\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String names = view.readCarNames();
        String count = view.readCount();

        assertThat(names).isEqualTo("hi,min");
        assertThat(count).isEqualTo("3");
    }

    @Test
    void 게임_진행_출력() {
        Car car1 = new Car("min", 2);
        Car car2 = new Car("bros", 3);

        view.printProgress(List.of(car1, car2));

        String output = outContent.toString();
        assertThat(output).contains("min : --", "bros : ---");
    }

    @Test
    void 게임_우승자_출력() {
        Car winningCar = new Car("min", 5);

        view.printResult(List.of(winningCar));

        String output = outContent.toString();
        assertThat(output).contains("최종 우승자 : min");
    }

    @Test
    void 게임_공동_우승자_출력() {
        Car winningCar1 = new Car("min", 5);
        Car winningCar2 = new Car("bros", 5);

        view.printResult(List.of(winningCar1, winningCar2));

        String output = outContent.toString();
        assertThat(output).contains("최종 우승자 : min, bros");
    }
}
