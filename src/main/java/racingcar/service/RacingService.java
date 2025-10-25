package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RacingService {
    private final Cars cars;

    public RacingService(Cars cars) {
        this.cars = cars;
    }

    public void playGame(int count) {
        for (int i = 0; i < count; i++) {
            cars.moveAll(generateRandomValues());
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars.getAll();
    }

    public List<Car> getWinningCars() {
        return cars.getWinningCars();
    }

    private List<Integer> generateRandomValues() {
        return getCars().stream()
                .map(car -> Randoms.pickNumberInRange(0, 9))
                .toList();
    }
}
