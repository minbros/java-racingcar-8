package racingcar.util;

import racingcar.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public final class InputParser {
    private InputParser() {
    }

    public static List<String> parseNames(String input) {
        List<String> names = Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .toList();

        if (names.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_FORMAT.getMessage());
        }

        return names;
    }

    public static int parseCount(String input) {
        String trimmedInput = input.trim();
        try {
            int count = Integer.parseInt(trimmedInput);
            if (count <= 0) throw new IllegalArgumentException(ErrorMessage.COUNT_MUST_BE_POSITIVE.getMessage());
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.COUNT_IS_NOT_IN_INT_RANGE.getMessage());
        }
    }
}
