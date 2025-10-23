package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.regex.Pattern;

public class Car {
    private final String name;
    private int position;

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateFields(name, position);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    private static void validateFields(String name, int position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_CANNOT_BE_BLANK.getMessage());
        }
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MUST_CONTAIN_ONLY_ALPHABETS_AND_NUMBERS.getMessage());
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_CANNOT_BE_MORE_THAN_5_CHARACTERS.getMessage());
        }
        if (position < 0) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_CANNOT_BE_NEGATIVE.getMessage());
        }
    }
}
