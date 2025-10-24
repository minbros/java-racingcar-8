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
        if (carList.size() != randomValues.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_RANDOM_VALUES_NOT_EQUALS_NUMBER_OF_CARS.getMessage());
        }
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(randomValues.get(i));
        }
    }
}
