package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public void add(Car car) {
        List<String> names = carList.stream().map(Car::getName).toList();
        if (names.contains(car.getName())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
        }
        carList.add(car);
    }

    public List<Car> get() {
        return List.copyOf(carList);
    }

    public void moveAll(List<Integer> randomValues) {

    }
}
