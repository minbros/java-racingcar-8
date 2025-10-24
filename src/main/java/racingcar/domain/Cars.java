package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> carList = new ArrayList<>();
    private final Set<String> names = new HashSet<>();

    public void add(Car car) {
        if (names.contains(car.getName())) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
        }
        carList.add(car);
        names.add(car.getName());
    }

    public List<Car> get() {
        return List.copyOf(carList);
    }

    public List<Car> getWinningCars() {
        if (carList.isEmpty()) {
            return List.of();
        }
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
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
