package racingcar.util;

import racingcar.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public final class InputParser {
    private InputParser() {
    }

    public static List<String> parseNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    public static int parseCount(String input) {
        String trimmedInput = input.trim();
        try {
            return Integer.parseInt(trimmedInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_IS_NOT_IN_INT_RANGE.getMessage());
        }
    }
}
